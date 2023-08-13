package com.hero.controller;

import com.hero.model.ApiResponseHeroes;
import com.hero.model.Hero;
import com.hero.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/hero")
public class HeroController {

    private final HeroService hs;

    @Autowired
    public HeroController(HeroService hs) {
        this.hs = hs;
    }

    @GetMapping("/{id}")
    public ResponseEntity getHeroId(@PathVariable("id") int id) {

        return ResponseEntity.ok(hs.getHero(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity getHeroName(@PathVariable("name") String name) {

        //List<ApiResponseHeroes> he = hs.getHero(name);
        //he.forEach((us) -> System.out.println(us.results()));

        /*he.forEach((us) -> {
            List<Hero> filteredHeroes = us.results().stream()
                    .filter(hero -> hero.name().toLowerCase().contains("man"))
                    .collect(Collectors.toList());
            filteredHeroes.forEach(hero -> System.out.println("Name: " + hero.name()));
        });*/

        //FILTRO
        List<Hero> he = hs.getHero(name);

        return ResponseEntity.ok(he);

    }
}
