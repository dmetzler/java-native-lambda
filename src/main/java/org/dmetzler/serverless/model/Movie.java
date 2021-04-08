package org.dmetzler.serverless.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.*;

/**
 * Movie
 */
public class Movie   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("releaseDate")
  private LocalDate releaseDate = null;

  @JsonProperty("director")
  private Person director = null;

  @JsonProperty("actors")
  private List<Person> actors = null;

  public Movie id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Movie title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   **/
  @JsonProperty("title")
  @NotNull
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Movie releaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  /**
   * Get releaseDate
   * @return releaseDate
   **/
  @JsonProperty("releaseDate")
  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Movie director(Person director) {
    this.director = director;
    return this;
  }

  /**
   * Get director
   * @return director
   **/
  @JsonProperty("director")
  public Person getDirector() {
    return director;
  }

  public void setDirector(Person director) {
    this.director = director;
  }

  public Movie actors(List<Person> actors) {
    this.actors = actors;
    return this;
  }

  public Movie addActorsItem(Person actorsItem) {
    if (this.actors == null) {
      this.actors = new ArrayList<>();
    }
    this.actors.add(actorsItem);
    return this;
  }

  /**
   * Get actors
   * @return actors
   **/
  @JsonProperty("actors")
  public List<Person> getActors() {
    return actors;
  }

  public void setActors(List<Person> actors) {
    this.actors = actors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Movie movie = (Movie) o;
    return Objects.equals(this.id, movie.id) &&
        Objects.equals(this.title, movie.title) &&
        Objects.equals(this.releaseDate, movie.releaseDate) &&
        Objects.equals(this.director, movie.director) &&
        Objects.equals(this.actors, movie.actors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, releaseDate, director, actors);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Movie {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
    sb.append("    director: ").append(toIndentedString(director)).append("\n");
    sb.append("    actors: ").append(toIndentedString(actors)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
