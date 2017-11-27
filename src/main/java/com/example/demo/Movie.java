package com.example.demo;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Long year;
    private String description;

    @ManyToMany
    @JoinTable(
            name="movie_actor", joinColumns=@JoinColumn(name="MOVIE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name="ACTOR_ID", referencedColumnName = "ID"))
    private Set<Actor> cast;
    public void addActor(Actor actor){
        cast.add(actor);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Actor> getCast() {
        return cast;
    }

    public void setCast(Set<Actor> cast) {
        this.cast = cast;
    }
}
