package com.example.springexam.service;


import com.example.springexam.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    public List<Movie> query(final String query){
        return Arrays.asList(
                Movie.builder().title("title1").link("http://1").userRating(4.5f).build(),
                Movie.builder().title("title2").link("http://2").userRating(4.5f).build()
        );
    }

}
