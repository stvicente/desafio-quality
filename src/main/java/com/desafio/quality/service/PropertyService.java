package com.desafio.quality.service;

import com.desafio.quality.dto.PropertyDTO;
import com.desafio.quality.dto.PropertyResponseDTO;
import com.desafio.quality.dto.RoomDTO;
import com.desafio.quality.dto.SizeDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PropertyService {

    Map<String, Double> districts = new HashMap<>();

    public PropertyService(){
        districts.put("chatuba", 22.);
        districts.put("rocha sobrinho", 25.);
        districts.put("centro", 35.);
        districts.put("cosmorama", 28.);
        districts.put("bnh", 30.);
    }

    public PropertyResponseDTO propertyValue(PropertyDTO propertyDTO) throws RuntimeException {
        List<RoomDTO> rooms = propertyDTO.getRooms();
        double value = districtValue(propertyDTO);
        double size = totalSize(rooms);
        return new PropertyResponseDTO(size, size*value, biggestRoom(rooms), sizePerRoom(rooms));
    }

    public SizeDTO biggestRoom(List<RoomDTO> rooms){
        return sizePerRoom(rooms)
                .stream()
                .max(Comparator.comparing(SizeDTO::getRoomSize))
                .orElse(null);
    }

    public double totalSize(List<RoomDTO> rooms){
        double totalSize = rooms
                .stream()
                .mapToDouble(c -> c.getRoomLength() * c.getRoomWidth())
                .sum();
        return Math.round(totalSize * 100.0) / 100.0;
    }

    public List<SizeDTO> sizePerRoom(List<RoomDTO> rooms){
        List<SizeDTO> size = new ArrayList<>();
        for(RoomDTO c : rooms){
            SizeDTO sizePerRoom = new SizeDTO();
            sizePerRoom.setRoomName(c.getRoomName());
            double roomSize = c.getRoomWidth()* c.getRoomLength();
            sizePerRoom.setRoomSize(Math.round(roomSize * 100.0) / 100.0);
            size.add(sizePerRoom);
        }
        return size;
    }

    public double districtValue(PropertyDTO propertyDTO) throws RuntimeException {
        String district = propertyDTO.getPropDistrict().toLowerCase();
        if(districts.containsKey(district)) return Math.round(districts.get(district) * 100.0) / 100.0;
        else {
            throw new RuntimeException("District is invalid");
        }
    }

}

