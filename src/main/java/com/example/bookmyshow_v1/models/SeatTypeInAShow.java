package com.example.bookmyshow_v1.models;

import com.example.bookmyshow_v1.models.Enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class SeatTypeInAShow extends BaseModel{

    @ManyToOne
    private MovieShow movieShow;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    private int price;
}
