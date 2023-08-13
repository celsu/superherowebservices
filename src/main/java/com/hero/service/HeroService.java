package com.hero.service;

import com.hero.model.ApiResponseHeroes;
import com.hero.model.Hero;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroService {

    private final String token = "6609039185784910";

    private final String API_URL = "https://superheroapi.com/api/"+token;


    public Hero getHero(int id) {
        RestTemplate restTemplate = new RestTemplate();
        Hero hero = restTemplate.getForObject(API_URL+"/"+id, Hero.class);
        System.out.println(hero);
        return hero;
    }

    public List<Hero> getHero(String name) {

        List<Hero> filteredHeroes = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        ApiResponseHeroes ar = restTemplate.getForObject(API_URL + "/search/" + name, ApiResponseHeroes.class);


        //CASO QUEIRA FITRAR
        List<Hero> heroes = ar.results();
        filteredHeroes = heroes.stream()
                .filter(hero -> hero.name().toLowerCase().contains("spider"))
                .collect(Collectors.toList());

        //System.out.println("LINK: "+API_URL + "/search/" + name);

        //RETORNO FILTRADO - PRECISA ALTERAR O RETORNO NO METODO
        return filteredHeroes;

        //return Arrays.asList(ar);
    }

}
