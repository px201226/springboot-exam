package com.example.springexam.web.dto;

import com.example.springexam.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMovieDto implements Serializable {

    private List<Item> items;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String title;
        private String link;
        private String actor;
        private String director;
        private float userRating;

        public Movie toEntity(){
            return Movie.builder()
                    .title(title)
                    .link(link)
                    .userRating(userRating)
                    .build();
        }
    }
    
}
