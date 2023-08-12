package com.hero.model;

import java.util.List;

public record ApiResponseHeroes(String response, String resultsFor, List<Hero> results) {
}

