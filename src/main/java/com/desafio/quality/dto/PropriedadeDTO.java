package com.desafio.quality.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class PropriedadeDTO {
    @Valid
    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
    @Size(min = 1, max = 30, message="O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "/^[A-Z][a-z]$/", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String propNome;

    @Valid
    @NotBlank(message = "O bairro não pode estar vazio.")
    @Size(min = 8, max = 45, message="O comprimento do bairro não pode exceder 45 caracteres.")
    private String propBairro;

    @Valid
    @NotNull(message = "O valor do m2 não pode estar vazio.")
    private double m2;

    @Valid
    private List<ComodoDTO> comodos;

    public PropriedadeDTO(){}

    public PropriedadeDTO(String propNome, String propBairro, double m2, List<ComodoDTO> comodos) {
        this.propNome = propNome;
        this.propBairro = propBairro;
        this.m2 = m2;
        this.comodos = comodos;
    }

    public String getPropNome() {
        return propNome;
    }

    public void setPropNome(String propNome) {
        this.propNome = propNome;
    }

    public String getPropBairro() {
        return propBairro;
    }

    public void setPropBairro(String propBairro) {
        this.propBairro = propBairro;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public List<ComodoDTO> getComodos() {
        return comodos;
    }

    public void setComodos(List<ComodoDTO> comodos) {
        this.comodos = comodos;
    }
}
