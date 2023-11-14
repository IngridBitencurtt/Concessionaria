package com.projeto.concessionaria.adapter.out;

import com.projeto.concessionaria.repository.ConcessionariaControl;

import java.util.List;

public interface ConcessionariaPortOut {
    List<ConcessionariaControl> findAllVehicle(String marca, String modelo, String tipoVeiculo, String cor, int ano, Double preco);
}
