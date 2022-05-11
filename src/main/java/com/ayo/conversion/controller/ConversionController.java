package com.ayo.conversion.controller;


import com.ayo.conversion.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/conversion")
public class ConversionController {

    @Autowired
    ConversionService conversionService;

    @GetMapping("/{measurement}/{system}/{value}")
    public ResponseEntity<String> convert(@PathVariable final String measurement, @PathVariable final String system, @PathVariable final Double value) {
        return conversionService.convert(measurement, system, value);
    }

}
