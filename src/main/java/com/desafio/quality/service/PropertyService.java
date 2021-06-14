package com.desafio.quality.service;

import com.desafio.quality.dto.PropertyDTO;
import com.desafio.quality.dto.PropertyResponseDTO;
import com.desafio.quality.dto.RoomDTO;
import com.desafio.quality.dto.SizeDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PropertyService {

//    map com os bairros e seus respectivos valores por m2
    private static final Map<String, Double> districts =
            new HashMap<>() {{
                put("chatuba", 22.);
                put("rocha sobrinho", 25.);
                put("centro", 35.);
                put("cosmorama", 28.);
                put("bnh", 30.);
            }};

//    formatar doubles para ter apenas duas casas decimais
    private double round(double num){ return Math.round(num * 100.0) / 100.0; }

//    calcula a area dos comodos
    private double caculateArea(RoomDTO roomDTO){
        return roomDTO.getRoomLength() * roomDTO.getRoomWidth();
    }

//    calcula o valor da propriedade e formata a response
    public PropertyResponseDTO propertyValue(PropertyDTO propertyDTO) throws RuntimeException {
        List<RoomDTO> rooms = propertyDTO.getRooms();
        double value = districtValue(propertyDTO);
        double size = totalSize(rooms);
        return new PropertyResponseDTO(size, size*value, biggestRoom(rooms), sizePerRoom(rooms));
    }

//    devolve o maior comodo
    public SizeDTO biggestRoom(List<RoomDTO> rooms){
        return sizePerRoom(rooms)
                .stream()
                .max(Comparator.comparing(SizeDTO::getRoomSize))
                .orElse(null);
    }

//    calcula o tamanho total da propriedade
    public double totalSize(List<RoomDTO> rooms){
        double totalSize = rooms
                .stream()
                .mapToDouble(this::caculateArea)
                .sum();
        return round(totalSize);
    }

//    calcula o tamanho por comodo
    public List<SizeDTO> sizePerRoom(List<RoomDTO> rooms){
        List<SizeDTO> sizePerRoom = new ArrayList<>();
        rooms.forEach(room -> sizePerRoom.add(new SizeDTO(room.getRoomName(), caculateArea(room))));
        return sizePerRoom;
    }

//    verifica se o bairro é valido e retorna o valor dele por m2
    public double districtValue(PropertyDTO propertyDTO) throws RuntimeException {
        String district = propertyDTO.getPropDistrict().toLowerCase();
        if(districts.containsKey(district)) return round(districts.get(district));
        else throw new RuntimeException("District is invalid");
    }

}

