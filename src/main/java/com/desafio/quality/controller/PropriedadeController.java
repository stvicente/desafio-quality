package com.desafio.quality.controller;

import com.desafio.quality.dto.PropertyDTO;
import com.desafio.quality.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("properties")
@RequiredArgsConstructor
public class PropriedadeController {
    private final PropertyService propertyService;

    @GetMapping(path = "/healthcheck")
    public String healthCheck() {
        return "OK";
    }

    @PostMapping(path = "/value")
    public ResponseEntity<?> propertyValue(@RequestBody @Valid PropertyDTO propertyDTO) throws RuntimeException {
        return ResponseEntity.ok(propertyService.propertyValue(propertyDTO));
    }
}
