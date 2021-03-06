package org.dmetzler.serverless;

public class MovieNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public MovieNotFoundException(String movieId) {
        super(String.format("Movie with id %s not found", movieId));
    }

}
