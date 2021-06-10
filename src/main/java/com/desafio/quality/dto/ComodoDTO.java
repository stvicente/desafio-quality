package com.desafio.quality.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ComodoDTO {
    @Valid
    @NotBlank(message = "O campo não pode estar vazio.")
    @Size(min = 8, max = 50, message="O nome do cômodo não pode exceder 30 caracteres.")
    @Pattern(regexp = "/^[A-Z][a-z]$/", message = "O nome da cômodo deve começar com uma letra maiúscula.")
    private String roomName;

    @Valid
    @NotNull(message = "O comprimento do cômodo não pode estar vazio.")
    @Range(min = 0, max = 25, message = "A largura máxima permitida por cômodo é de 25 metros")
    private double roomWidth;

    @Valid
    @NotNull(message = "Comprimento do comodo é obrigatório")
    @Range(min = 0, max = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private double roomLength;

    public ComodoDTO(String roomName, double roomWidth, double roomLength) {
        this.roomName = roomName;
        this.roomWidth = roomWidth;
        this.roomLength = roomLength;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getRoomWidth() {
        return roomWidth;
    }

    public void setRoomWidth(double roomWidth) {
        this.roomWidth = roomWidth;
    }

    public double getRoomLength() {
        return roomLength;
    }

    public void setRoomLength(double roomLength) {
        this.roomLength = roomLength;
    }
}
