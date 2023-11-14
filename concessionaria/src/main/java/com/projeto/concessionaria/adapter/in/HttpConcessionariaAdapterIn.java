package com.projeto.concessionaria.adapter.in;

import com.projeto.concessionaria.adapter.in.dto.ConcessionariaDto;
import com.projeto.concessionaria.core.ConcessionariaPortIn;
import com.projeto.concessionaria.domain.Concessionaria;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/concessionaria")
public class HttpConcessionariaAdapterIn {
    public final ConcessionariaPortIn concessionariaPortIn;

    public HttpConcessionariaAdapterIn(ConcessionariaPortIn concessionariaPortIn) {
        this.concessionariaPortIn = concessionariaPortIn;
    }

  @GetMapping
    public ResponseEntity<List<ConcessionariaDto>> consultaEstoque(@RequestParam(value = "marca", required = false) String marca,
                                                                  @RequestParam(value = "modelo", required = false) String modelo,
                                                                  @RequestParam(value = "tipoVeiculo", required = false) String tipoVeiculo,
                                                                  @RequestParam(value = "cor", required = false) String cor,
                                                                  @RequestParam(value = "ano", required = false) int ano,
                                                                  @RequestParam(value = "preco", required = false) Double preco){



        List<Concessionaria> findAllVehiclesReturn = this.concessionariaPortIn.findAllVehicles(marca,
                modelo, tipoVeiculo, cor, ano, preco);
        List<ConcessionariaDto> concessionariaDtoList = new ArrayList<>();

        for (Concessionaria concessionaria : findAllVehiclesReturn){
            ConcessionariaDto concessionariaDto = ConcessionariaDto.from(concessionaria);
            concessionariaDtoList.add(concessionariaDto);
        }


      return ResponseEntity.ok(concessionariaDtoList);
  }


}

