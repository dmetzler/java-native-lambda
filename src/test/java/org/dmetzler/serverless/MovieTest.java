package org.dmetzler.serverless;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import java.util.UUID;

import org.dmetzler.serverless.model.Movie;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class MovieTest {
    
    @Test
    public void can_get_movie() {
        when()
            .get("/movie").
        then()
            .contentType("application/json")
            .body("list.size()", greaterThanOrEqualTo(0));
    }

    @Test
    public void can_create_movie() {
        Movie movie = new Movie().id(UUID.randomUUID()).title("A Movie");

        given()
            .contentType(ContentType.JSON)
            .body(movie)            
        .when()
            .post("/movie").
        then()
            .contentType("application/json")
            .body("id", equalTo(movie.getId().toString()))
            .body("title", equalTo(movie.getTitle()));


        when()
            .get("/movie").
        then()
            .contentType("application/json")
            .body("list.size()", greaterThanOrEqualTo(1));

        given().            
        when()
            .get(String.format("/movie/%s", movie.getId()))
        .then()
            .contentType("application/json")
            .body("id", equalTo(movie.getId().toString()))
            .body("title", equalTo(movie.getTitle()));
                
    }

    @Test
    public void can_update_movie() {
        Movie movie = new Movie().id(UUID.randomUUID()).title("A Movie");

        given()
            .contentType(ContentType.JSON)
            .body(movie)            
        .when()
            .post("/movie")
        .then()
            .contentType("application/json")
            .body("id", equalTo(movie.getId().toString()))
            .body("title", equalTo(movie.getTitle()));


        movie.setTitle("Another Movie");
        String movieResourceEndpoint = String.format("/movie/%s", movie.getId());
        
        given()
            .contentType(ContentType.JSON)
            .body(movie)            
        .when()
            .put(movieResourceEndpoint)
        .then()
            .contentType("application/json")            
            .body("title", equalTo(movie.getTitle()));

        when()
            .get(movieResourceEndpoint).
        then()
            .contentType("application/json")
            .body("id", equalTo(movie.getId().toString()))
            .body("title", equalTo(movie.getTitle()));
                        
    }

    @Test
    public void exceptions_are_mapped() {
        when()
            .get("/movie/nonexistent").
        then()
            .contentType("application/json")
            .statusCode(404)
            .body("type", equalTo("MovieNotFoundException"))
            .body("message", equalTo("Movie with id nonexistent not found"));
    }



    
}
