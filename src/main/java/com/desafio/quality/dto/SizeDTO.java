package com.desafio.quality.dto;

public class SizeDTO {
    public String roomName;
    public double roomSize;

    public SizeDTO() { }

    public SizeDTO(String roomName, double roomSize) {
        this.roomName = roomName;
        this.roomSize = roomSize;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(double roomSize) {
        this.roomSize = roomSize;
    }
}
