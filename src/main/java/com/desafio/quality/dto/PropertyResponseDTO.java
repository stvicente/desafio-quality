package com.desafio.quality.dto;

import java.util.List;

public class PropertyResponseDTO {
    public double totalSize;
    public double value;
    public SizeDTO biggestRoom;
    public List<SizeDTO> sizePerRoom;

    public PropertyResponseDTO(double totalSize, double value, SizeDTO biggestRoom, List<SizeDTO> sizePerRoom) {
        this.totalSize = totalSize;
        this.value = value;
        this.biggestRoom = biggestRoom;
        this.sizePerRoom = sizePerRoom;
    }
}
