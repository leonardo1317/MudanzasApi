package com.reto.mudanzas.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/competitor")
public class CompetitorRest {

    @GetMapping()
    public String findAll() {
      
        return "Hello Word";
    }

}
