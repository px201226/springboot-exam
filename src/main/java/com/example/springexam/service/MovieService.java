package com.example.springexam.service;


import com.example.springexam.domain.Movie;
import com.example.springexam.domain.MovieGroup;
import com.example.springexam.domain.MovieRepository;
import com.example.springexam.exception.unchecked.ClientNoContentRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> query(final String query){
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getListOrderRating();
    }


    public Movie getHighestRatingMovie(final String query){
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getHighestRaingMovie().orElseThrow(ClientNoContentRuntimeException::new);
    }
}
