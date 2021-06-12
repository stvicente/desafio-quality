package com.desafio.quality.unit;

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
        double size = totalSize(propertyDTO.getRooms());
        RoomDTO biggestRoom = biggestRoom(rooms);
        List<SizeDTO> sizePerRoom = sizePerRoom(rooms);
        return new PropertyResponseDTO(size, size*value, biggestRoom, sizePerRoom);
    }

    public RoomDTO biggestRoom(List<RoomDTO> rooms){
        return rooms
                .stream()
                .max(Comparator.comparing(c -> (c.getRoomWidth() * c.getRoomLength())))
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

    public double districtValue(PropertyDTO propertyDTO) throws Exception {
        Map<String, Double> districts = new HashMap<>();
        districts.put("chatuba", 22.);
        districts.put("rocha sobrinho", 25.);
        districts.put("centro", 35.);
        districts.put("cosmorama", 28.);
        districts.put("bnh", 30.);
        String district = propertyDTO.getPropDistrict().toLowerCase();
        if(districts.containsKey(district)) return Math.round(districts.get(district) * 100.0) / 100.0;
        else {
            throw new Exception("District is invalid");
        }
    }

}

