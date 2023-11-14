package com.projeto.concessionaria.domain;

import com.projeto.concessionaria.repository.ConcessionariaControl;
import lombok.Data;

@Data
public class Concessionaria {
    private String tag;
    private String model;
    private String vehicleType;
    private String color;
    private int ano;
    private double price;


    public static Concessionaria from(ConcessionariaControl concessionariaControl) {
        Concessionaria concessionaria = new Concessionaria();
        concessionaria.setTag(concessionariaControl.getMarca());
        concessionaria.setModel(concessionariaControl.getModelo());
        concessionaria.setVehicleType(concessionariaControl.getTipoVeiculo());
        concessionaria.setColor(concessionariaControl.getCor());
        concessionaria.setAno(concessionariaControl.getAno());
        concessionaria.setPrice(concessionariaControl.getPreco());
        return concessionaria;
    }
}