package com.example.springexam.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class MovieGroup {

    private List<Movie> movies;

    public List<Movie> getListOrderRating(){
        return movies.stream()
                .filter(m-> m.getUserRating() != 0.0f)
                .sorted((a,b)-> a.getUserRating() > b.getUserRating() ? -1 : 1)
                .collect(Collectors.toList());
    }

    public Optional<Movie> getHighestRaingMovie(){
        return getListOrderRating().stream().findFirst();
    }

}
