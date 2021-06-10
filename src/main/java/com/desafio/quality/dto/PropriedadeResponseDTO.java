package com.desafio.quality.dto;

import java.util.List;

public class PropriedadeResponseDTO {
    public double metragemTotal;
    public double valor;
    public ComodoDTO maiorComodo;
    public List<MetragemDTO> metragemPorComodo;

    public PropriedadeResponseDTO() {}

    public PropriedadeResponseDTO(double metragemTotal, double valor, ComodoDTO maiorComodo, List<MetragemDTO> metragemPorComodo) {
        this.metragemTotal = metragemTotal;
        this.valor = valor;
        this.maiorComodo = maiorComodo;
        this.metragemPorComodo = metragemPorComodo;
    }

    public double getMetragemTotal() {
        return metragemTotal;
    }

    public void setMetragemTotal(double metragemTotal) {
        this.metragemTotal = metragemTotal;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ComodoDTO getMaiorComodo() {
        return maiorComodo;
    }

    public void setMaiorComodo(ComodoDTO maiorComodo) {
        this.maiorComodo = maiorComodo;
    }

    public List<MetragemDTO> getMetragemPorComodo() {
        return metragemPorComodo;
    }

    public void setMetragemPorComodo(List<MetragemDTO> metragemPorComodo) {
        this.metragemPorComodo = metragemPorComodo;
    }
}
