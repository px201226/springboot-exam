package com.example.springexam.controller;


import com.example.springexam.domain.Movie;
import com.example.springexam.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
public class MoviceController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getMoviesByQuery(@RequestParam("query") String query){
        return movieService.query(query);
    }
}
