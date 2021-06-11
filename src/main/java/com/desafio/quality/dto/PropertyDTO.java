package com.desafio.quality.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class PropertyDTO {
    @Valid
    @NotBlank(message = "Property name cannot be empty.")
    @Size(min = 1, max = 30, message="Property name cannot be longer than 30 characters")
    @Pattern(regexp = "[A-Z].*", message = "Property name must start with a capital letter")
    private String propName;

    @Valid
    @NotBlank(message = "District name cannot be empty")
    @Size(min = 1, max = 45, message="District name cannot be longer than 45 characters")
    private String propDistrict;

    @Valid
    private List<RoomDTO> rooms;

    public PropertyDTO(){}

    public PropertyDTO(String propName, String propDistrict, List<RoomDTO> rooms) {
        this.propName = propName;
        this.propDistrict = propDistrict;
        this.rooms = rooms;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getPropDistrict() {
        return propDistrict;
    }

    public void setPropDistrict(String propDistrict) {
        this.propDistrict = propDistrict;
    }

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDTO> rooms) {
        this.rooms = rooms;
    }
}
