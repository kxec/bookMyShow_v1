package com.example.bookmyshow_v1.models;

import com.example.bookmyshow_v1.models.Enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{

    private String title;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> requiredFeatures;

    @ManyToMany
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;

}
