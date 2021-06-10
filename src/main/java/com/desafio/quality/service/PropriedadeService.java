package com.desafio.quality.service;

import com.desafio.quality.dto.ComodoDTO;
import com.desafio.quality.dto.MetragemDTO;
import com.desafio.quality.dto.PropriedadeDTO;
import com.desafio.quality.dto.PropriedadeResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PropriedadeService {

    public PropriedadeResponseDTO calculoPropriedade(PropriedadeDTO propriedadeDTO){
        PropriedadeResponseDTO informacoes = new PropriedadeResponseDTO();
        double metragem = metragemTotal(propriedadeDTO.getComodos());
        List<ComodoDTO> comodos = propriedadeDTO.getComodos();
        informacoes.setMetragemTotal(metragem);
        informacoes.setMaiorComodo(maiorComodo(comodos));
        informacoes.setMetragemPorComodo(metragemPorComodo(comodos));
        return informacoes;
    }


    private ComodoDTO maiorComodo(List<ComodoDTO> comodo){
        return comodo
                .stream()
                .max(Comparator.comparing(c -> (c.getRoomWidth() * c.getRoomLength())))
                .get();

    }

    private double metragemTotal(List<ComodoDTO> comodo){
        return comodo
                .stream()
                .mapToDouble(c ->c.getRoomLength() * c.getRoomWidth())
                .sum();
    }

    private List<MetragemDTO> metragemPorComodo(List<ComodoDTO> comodo){
        List<MetragemDTO> metragem = new ArrayList<>();
        for(ComodoDTO c : comodo){
            MetragemDTO metragemPorComodo = new MetragemDTO();
            metragemPorComodo.setRoomName(c.getRoomName());
            metragemPorComodo.setRoomSize(c.getRoomWidth()* c.getRoomLength());
            metragem.add(metragemPorComodo);
        }
        return metragem;
    }

}

