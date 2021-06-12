package com.desafio.quality.integration;

import com.desafio.quality.dto.PropertyDTO;
import com.desafio.quality.unit.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<?> propertyValue(@RequestBody @Valid PropertyDTO propertyDTO, BindingResult result) throws Exception {
        if(result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (ObjectError error : result.getAllErrors()) {
                String field = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.add("ERROR with message: {" + errorMessage +  "} for field: {" + field + "}");
            }
            return ResponseEntity.badRequest().body(errors);

        }
        if(propertyService.propertyValue(propertyDTO) != null)
            return ResponseEntity.ok(propertyService.propertyValue(propertyDTO));

        return ResponseEntity.badRequest().body("Failed to calculate property value");
    }
}
