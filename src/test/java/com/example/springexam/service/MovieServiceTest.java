package com.example.springexam.service;

import com.example.springexam.domain.Movie;
import com.example.springexam.domain.MovieGroup;
import com.example.springexam.domain.MovieRepository;
import com.example.springexam.exception.unchecked.ClientNoContentRuntimeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;


    @Test
    @DisplayName("평점 순으로 정렬되는지 검증")
    public void shouldSortedInOrderOfGrade(){

        //given
        String query = "테스트_쿼리";
        String expectedTopRankingMovieTitle = "영화3";
        given(movieRepository.findByQuery(anyString())).willReturn(getSubMovies());
        MovieService movieService = new MovieService(movieRepository);

        //when
        List<Movie> actualMovieList = movieService.query(query);

        actualMovieList.stream().forEach(a-> System.out.println(a));

        //then
        assertEquals(expectedTopRankingMovieTitle,actualMovieList.stream().findFirst().get().getTitle());
    }

    @Test
    @DisplayName("평점이 0인 영화를 제외하는지 검증")
    public void shouldExcludeGradeIsZero(){

        //given
        String query = "테스트_쿼리";
        given(movieRepository.findByQuery(anyString())).willReturn(getSubMovies());
        MovieService movieService = new MovieService(movieRepository);

        //when
        List<Movie> actualMovieList = movieService.query(query);


        //then
        actualMovieList.forEach(m->assertNotEquals(m.getUserRating(),0.0f));

    }

    @Test
    @DisplayName("평짐이 가장 높은 영화를 반환할 때 영화목록이 없으면 예외를 반환하는지 검증")
    public void shouldReturnDefalutMovieWhenEmptyMovies(){

        //given
        String expectDefaultMovieTitle = "기본영화";
        String query = "test";
        given(movieRepository.findByQuery(anyString())).willReturn(Collections.emptyList());
        MovieService movieService = new MovieService(movieRepository);

        //when, then
        assertThrows(ClientNoContentRuntimeException.class, ()->{
            movieService.getHighestRatingMovie(query);
        });
    }

    @Test
    @DisplayName("평점이 가장 높은 영화를 반환하는지 검증")
    public void shouldReturnHighestRatingMovie(){

        //given
        String query = "test";
        String expectMovieTitle = "영화3";
        given(movieRepository.findByQuery(anyString())).willReturn(getSubMovies());
        MovieService movieService = new MovieService(movieRepository);

        //when
        Movie highestRatingMovie = movieService.getHighestRatingMovie(query);

        //then
        assertEquals(expectMovieTitle, highestRatingMovie.getTitle());
    }

    private List<Movie> getSubMovies() {
        return Arrays.asList(
                Movie.builder().title("영화1").userRating(0.0f).build(),
                Movie.builder().title("영화2").userRating(0.5f).build(),
                Movie.builder().title("영화3").userRating(5.0f).build()
        );
    }
}