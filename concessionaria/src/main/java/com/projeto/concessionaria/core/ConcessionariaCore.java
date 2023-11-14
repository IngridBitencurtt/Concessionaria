package com.projeto.concessionaria.core;

import com.projeto.concessionaria.adapter.out.ConcessionariaPortOut;
import com.projeto.concessionaria.domain.Concessionaria;
import com.projeto.concessionaria.repository.ConcessionariaControl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ConcessionariaCore implements ConcessionariaPortIn {
    public final ConcessionariaPortOut concessionariaPortOut;

    public ConcessionariaCore(ConcessionariaPortOut concessionariaPortOut) {
        this.concessionariaPortOut = concessionariaPortOut;
    }

    @Override
    public List<Concessionaria> findAllVehicles(String marca, String modelo, String tipoVeiculo, String cor, int ano, Double preco) {

        List<ConcessionariaControl> concessionariaControlList = this.concessionariaPortOut.findAllVehicle(marca, modelo,
                tipoVeiculo, cor, ano, preco);
        List<Concessionaria> concessionariaList = new ArrayList<>();

        for (ConcessionariaControl concessionariaControl : concessionariaControlList){
            Concessionaria concessionaria = Concessionaria.from(concessionariaControl);
            concessionariaList.add(concessionaria);

        }
        return concessionariaList;
    }
}
