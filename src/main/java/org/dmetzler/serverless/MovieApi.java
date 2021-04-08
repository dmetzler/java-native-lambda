package org.dmetzler.serverless;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.dmetzler.serverless.model.Movie;

@Path("/movie")
@Produces({ "application/json" })
public class MovieApi {

    private MovieApiService delegate;

    @Inject
    public MovieApi(MovieApiService delegate) {
        this.delegate = delegate;
    }

    @POST
    @Path("/")
    @Consumes({ "application/json" })
    public Movie addMovie(Movie body) {
        return delegate.addMovie(body);
    }

    @DELETE
    @Path("/{id}")
    public Movie deleteMovieById(@PathParam("id") String id) throws MovieNotFoundException {
        return delegate.deleteMovieById(id);
    }

    @GET
    @Path("/{id}")
    @Produces({ "application/json" })
    public Movie getMovieById(@PathParam("id") String id) throws MovieNotFoundException {
        return delegate.getMovieById(id);

    }

    @GET
    @Path("/")
    @Produces({ "application/json" })
    public List<Movie> searchMovie(@QueryParam("searchString") String searchString) {
        return delegate.searchMovie(searchString);
    }

    @PUT
    @Path("/{id}")
    @Consumes({ "application/json" })
    public Movie updateMovieById(@PathParam("id") String id, Movie body) throws MovieNotFoundException {
        return delegate.updateMovieById(id, body);
    }
}
