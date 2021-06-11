package com.desafio.quality.service;

import com.desafio.quality.dto.PropertyDTO;
import com.desafio.quality.dto.PropertyResponseDTO;
import com.desafio.quality.dto.RoomDTO;
import com.desafio.quality.dto.SizeDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PropertyService {

    public PropertyResponseDTO propertyValue(PropertyDTO propertyDTO) throws Exception {
        PropertyResponseDTO response = new PropertyResponseDTO();
        List<RoomDTO> rooms = propertyDTO.getRooms();
        double value = districtValue(propertyDTO);
//        if(value < 0) throw new Exception("District is invalid");
        double size = totalSize(propertyDTO.getRooms());
        response.setValue(size*value);
        response.setTotalSize(size);
        response.setBiggestRoom(biggestRoom(rooms));
        response.setSizePerRoom(sizePerRoom(rooms));
        return response;
    }


    public RoomDTO biggestRoom(List<RoomDTO> rooms){
        return rooms
                .stream()
                .max(Comparator.comparing(c -> (c.getRoomWidth() * c.getRoomLength())))
                .orElse(null);
    }

    public double totalSize(List<RoomDTO> rooms){
        return rooms
                .stream()
                .mapToDouble(c ->c.getRoomLength() * c.getRoomWidth())
                .sum();
    }

    public List<SizeDTO> sizePerRoom(List<RoomDTO> rooms){
        List<SizeDTO> size = new ArrayList<>();
        for(RoomDTO c : rooms){
            SizeDTO sizePerRoom = new SizeDTO();
            sizePerRoom.setRoomName(c.getRoomName());
            sizePerRoom.setRoomSize(c.getRoomWidth()* c.getRoomLength());
            size.add(sizePerRoom);
        }
        return size;
    }

    public Double districtValue(PropertyDTO propertyDTO) throws Exception {
        Map<String, Double> districts = new HashMap<>();
        districts.put("Chatuba", 22.);
        districts.put("Rocha Sobrinho", 25.);
        districts.put("Centro", 35.);
        districts.put("Cosmorama", 28.);
        districts.put("BNH", 30.);
        String district = propertyDTO.getPropDistrict();
        if(districts.containsKey(district)) return districts.get(district);
        else {
            throw new Exception("District is invalid");
        }
    }

}

