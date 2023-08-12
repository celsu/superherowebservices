package com.hero.service;

import com.hero.model.ApiResponseHeroes;
import com.hero.model.Hero;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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

    public List<ApiResponseHeroes> getHero(String name) {
        RestTemplate restTemplate = new RestTemplate();
        ApiResponseHeroes ar = restTemplate.getForObject(API_URL + "/search/" + name, ApiResponseHeroes.class);

        //System.out.println("LINK: "+API_URL + "/search/" + name);

        return Arrays.asList(ar);
    }

}
