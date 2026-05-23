package com.example.bookmyshow_v1.models;

import com.example.bookmyshow_v1.models.Enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String number;

    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seats;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> supportedFeatures;
    private int maxRows;
    private int maxColumns;

    @ManyToOne
    private Theatre theatre;
}
