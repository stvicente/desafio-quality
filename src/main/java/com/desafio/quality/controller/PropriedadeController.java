package com.desafio.quality.controller;

import com.desafio.quality.dto.PropriedadeDTO;
import com.desafio.quality.service.PropriedadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("propriedades")
@RequiredArgsConstructor
public class PropriedadeController {
    private final PropriedadeService propriedadeService;

    @GetMapping(path = "/healthcheck")
    public String healthCheck() {
        return "OK";
    }

    @PostMapping(path = "/")
    public ResponseEntity calculoPropriedade(@RequestBody PropriedadeDTO propriedadeDTO) {
        return ResponseEntity.ok(propriedadeService.calculoPropriedade(propriedadeDTO));
    }
}
