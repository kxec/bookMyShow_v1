package com.example.bookmyshow_v1.models;

import com.example.bookmyshow_v1.models.Enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SeatInAShow extends BaseModel{

    @ManyToOne
    private Seat seat;
    @ManyToOne
    private MovieShow movieShow;

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;

}
