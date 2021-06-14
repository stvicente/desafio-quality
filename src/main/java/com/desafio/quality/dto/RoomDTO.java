package com.desafio.quality.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RoomDTO {

    @NotBlank(message = "Room name cannot be empty.")
    @Size(min = 1, max = 30, message="Room name cannot be longer than 30 characters")
    @Pattern(regexp = "[A-Z].*", message = "Room name must start with a capital letter")
    private String roomName;

    @NotNull(message = "Room's width cannot be empty")
    @Range(min = 0, max = 25, message = "Room's width cannot be bigger than 25 meters")
    private double roomWidth;

    @NotNull(message = "Room's length cannot be empty")
    @Range(min = 0, max = 33, message = "Room' length cannot be bigger than 33 meters")
    private double roomLength;

    public RoomDTO(String roomName, double roomWidth, double roomLength) {
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
