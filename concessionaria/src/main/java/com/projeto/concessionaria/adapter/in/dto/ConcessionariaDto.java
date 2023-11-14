package com.projeto.concessionaria.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.projeto.concessionaria.domain.Concessionaria;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConcessionariaDto {
    private String marca;
    private String modelo;
    private String tipoVeiculo;
    private String cor;
    private int ano;
    private double preco;

    public ConcessionariaDto(){
    }


    public ConcessionariaDto(String marca,
                             String modelo,
                             String tipoVeiculo,
                             String cor,
                             int ano,
                             double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoVeiculo = tipoVeiculo;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
    }

    public static ConcessionariaDto from(Concessionaria concessionaria) {
        return  new ConcessionariaDto((concessionaria.getTag())
                ,concessionaria.getModel()
                , concessionaria.getVehicletype()
                ,concessionaria.getColor()
                ,concessionaria.getAno()
                ,concessionaria.getPrice());
    }

    public String getMarca() {
        return marca;
    }

    public ConcessionariaDto setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public ConcessionariaDto setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public ConcessionariaDto setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
        return this;
    }

    public String getCor() {
        return cor;
    }

    public ConcessionariaDto setCor(String cor) {
        this.cor = cor;
        return this;
    }

    public int getAno() {
        return ano;
    }

    public ConcessionariaDto setAno(int ano) {
        this.ano = ano;
        return this;
    }

    public double getPreco() {
        return preco;
    }

    public ConcessionariaDto setPreco(double preco) {
        this.preco = preco;
        return this;
    }
}
