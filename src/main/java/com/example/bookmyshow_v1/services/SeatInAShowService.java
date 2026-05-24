package com.example.bookmyshow_v1.services;

import com.example.bookmyshow_v1.models.Enums.SeatStatus;
import com.example.bookmyshow_v1.models.SeatInAShow;
import com.example.bookmyshow_v1.repositories.SeatInAShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SeatInAShowService {

    private SeatInAShowRepository seatInAShowRepository;

    @Autowired
    public SeatInAShowService(SeatInAShowRepository seatInAShowRepository)
    {
        this.seatInAShowRepository = seatInAShowRepository;
    }

    public List<SeatInAShow> findSeatsById(List<Long> seatIds)
    {

        List<SeatInAShow> seatsInAShow = seatInAShowRepository.findAllById(seatIds);
        return seatsInAShow;
    }

    public List<SeatInAShow> lockSeats(List<SeatInAShow> seatsInAShow , Date currTime)
    {
        List<SeatInAShow> updatedSeats = new ArrayList<>();

        for(SeatInAShow seat : seatsInAShow)
        {
            seat.setSeatStatus(SeatStatus.Locked);
            seat.setLockedAt(currTime);
            seat = seatInAShowRepository.save(seat);
            updatedSeats.add(seat);
        }

        return updatedSeats;

    }


}
