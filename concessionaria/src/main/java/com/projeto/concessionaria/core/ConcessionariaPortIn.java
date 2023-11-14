package com.projeto.concessionaria.core;


import com.projeto.concessionaria.domain.Concessionaria;

import java.util.List;

public interface ConcessionariaPortIn {
    List<Concessionaria> findAllVehicles(String marca, String modelo, String tipoVeiculo, String cor, int ano, Double preco);
}

