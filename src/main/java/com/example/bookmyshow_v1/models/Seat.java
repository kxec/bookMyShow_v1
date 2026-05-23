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
public class Seat extends BaseModel{

    private String number;
    private int seatRow;
    private int seatColumn;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    @ManyToOne
    private Auditorium auditorium;

}
