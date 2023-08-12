package com.hero.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hero")
public class HeroController {


    @GetMapping("/{id}")
    public ResponseEntity getHero(@PathVariable("id") Long id){
        return ResponseEntity.ok("Metodo GET: "+id);
    }
}
