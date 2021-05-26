package com.example.springexam.domain;

import com.example.springexam.config.NaverProperites;
import com.example.springexam.exception.ExceptionMessage;
import com.example.springexam.exception.unchecked.ClientAuthRuntimeException;
import com.example.springexam.exception.unchecked.ClientBadRequestRuntimeException;
import com.example.springexam.exception.unchecked.ClientRuntimeException;
import com.example.springexam.web.dto.ResponseMovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Component
@RequiredArgsConstructor
public class MovieRepositoryImpl implements  MovieRepository{

    private final RestTemplate restTemplate;
    private final NaverProperites naverProperites;

    @Override
    public List<Movie> findByQuery(String query) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverProperites.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverProperites.getClientSecret());

        String url = naverProperites.getMovieUrl() + "?query=" + query;

        try {
            return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseMovieDto.class)
                    .getBody()
                    .getItems()
                    .stream()
                    .map(ResponseMovieDto.Item::toEntity)
                    .collect(Collectors.toList());

        } catch (HttpClientErrorException ex){
            switch (ex.getStatusCode()) {
                case UNAUTHORIZED:
                    throw new ClientAuthRuntimeException(ExceptionMessage.NAVER_API_UNAUTHORIZED);
                case BAD_REQUEST:
                    throw new ClientBadRequestRuntimeException(ExceptionMessage.NAVER_API_UNAUTHORIZED);
                default:
                    throw new ClientRuntimeException(ex.getMessage());
            }
        } catch (RuntimeException ex){
            throw new ClientRuntimeException(ex.getMessage());
        }

    }
}
