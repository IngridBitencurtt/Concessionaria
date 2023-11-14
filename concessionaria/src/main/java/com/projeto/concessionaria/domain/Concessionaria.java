package com.projeto.concessionaria.domain;

import lombok.Data;

@Data
public class Concessionaria {
    private String tag;
    private String model;
    private String vehicletype;
    private String color;
    private int ano;
    private double price;
}
