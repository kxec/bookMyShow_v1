package com.example.bookmyshow_v1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class MovieShow extends BaseModel{

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Auditorium auditorium;
    private Date entryTime;
    private Date exitTime;
    private int lockingTimeout;
    private int maxTicketsAllowedForOneUser;
}
