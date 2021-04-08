package org.dmetzler.serverless;

import java.util.List;
import org.dmetzler.serverless.model.Movie;

public interface MovieApiService {

    Movie addMovie(Movie body);

    Movie deleteMovieById(String id) throws MovieNotFoundException;

    Movie getMovieById(String id) throws MovieNotFoundException;

    List<Movie> searchMovie(String searchString);

    Movie updateMovieById(String id, Movie body) throws MovieNotFoundException;

}
