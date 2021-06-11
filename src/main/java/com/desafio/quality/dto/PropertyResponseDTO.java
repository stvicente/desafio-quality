package com.desafio.quality.dto;

import java.util.List;

public class PropertyResponseDTO {
    public double totalSize;
    public double value;
    public RoomDTO biggestRoom;
    public List<SizeDTO> sizePerRoom;

    public PropertyResponseDTO() {}

    public PropertyResponseDTO(double totalSize, double value, RoomDTO biggestRoom, List<SizeDTO> sizePerRoom) {
        this.totalSize = totalSize;
        this.value = value;
        this.biggestRoom = biggestRoom;
        this.sizePerRoom = sizePerRoom;
    }

    public double getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(double totalSize) {
        this.totalSize = totalSize;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public RoomDTO getBiggestRoom() {
        return biggestRoom;
    }

    public void setBiggestRoom(RoomDTO biggestRoom) {
        this.biggestRoom = biggestRoom;
    }

    public List<SizeDTO> getSizePerRoom() {
        return sizePerRoom;
    }

    public void setSizePerRoom(List<SizeDTO> sizePerRoom) {
        this.sizePerRoom = sizePerRoom;
    }
}
