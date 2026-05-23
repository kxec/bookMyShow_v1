package com.example.bookmyshow_v1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{

    @ManyToOne
    private AppUser user;

    @OneToMany
    @JoinColumn(name = "ticket_id")
    private List<SeatInAShow> seatsBooked;

    private Date bookingTime;

    @OneToOne(mappedBy = "ticket")
    private Payment payment;
    private int amount;
}
