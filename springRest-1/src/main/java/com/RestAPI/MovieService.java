package com.RestAPI;

import org.springframework.stereotype.Service;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;


@Service
public class MovieService {

    private MovieApiClient movieApiClient;

    public MovieService(MovieApiClient movieApiClient) {
        this.movieApiClient = movieApiClient;
    }

    public Movie getMovieDetails(String title) throws IOException {
        String response = movieApiClient.searchMovie(title);
        if (response == null) {
            return null;
        } else {
            Movie movie = new Movie();
            movie.setTitle(JsonPath.read(response, "$.Title"));
            movie.setYear(JsonPath.read(response, "$.Year"));
            movie.setRated(JsonPath.read(response, "$.Rated"));
            movie.setReleased(JsonPath.read(response, "$.Released"));
            movie.setRuntime(JsonPath.read(response, "$.Runtime"));
            movie.setGenre(JsonPath.read(response, "$.Genre"));
            movie.setDirector(JsonPath.read(response, "$.Director"));
            movie.setWriter(JsonPath.read(response, "$.Writer"));
            movie.setActors(JsonPath.read(response, "$.Actors"));
            movie.setPlot(JsonPath.read(response, "$.Plot"));
            movie.setLanguage(JsonPath.read(response, "$.Language"));
            movie.setCountry(JsonPath.read(response, "$.Country"));
            movie.setAwards(JsonPath.read(response, "$.Awards"));
            movie.setPoster(JsonPath.read(response, "$.Poster"));
            movie.setRottenTomatoesRating(JsonPath.read(response, "$.Ratings[?(@.Source=='Rotten Tomatoes')].Value"));
            return movie;
        }
    }
}