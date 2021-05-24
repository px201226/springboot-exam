package com.example.springexam.domain;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;


@Getter
@Builder
public class Movie implements Serializable {

    private String title;
    private String link;
    private float userRating;
}
