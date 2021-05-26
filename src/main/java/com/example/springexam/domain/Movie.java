package com.example.springexam.domain;

import com.example.springexam.web.dto.ResponseMovieDto;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;


@Getter
@Builder
public class Movie implements Serializable {

    private String title;
    private String link;
    private float userRating;

    @Override
    public String toString(){
        return String.format("%s,%s,%f",title,link,userRating);
    }
}
