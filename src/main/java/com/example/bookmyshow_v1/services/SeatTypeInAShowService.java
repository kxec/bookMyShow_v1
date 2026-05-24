package com.example.bookmyshow_v1.services;

import com.example.bookmyshow_v1.models.Enums.SeatType;
import com.example.bookmyshow_v1.models.MovieShow;
import com.example.bookmyshow_v1.models.SeatInAShow;
import com.example.bookmyshow_v1.models.SeatTypeInAShow;
import com.example.bookmyshow_v1.repositories.SeatInAShowRepository;
import com.example.bookmyshow_v1.repositories.SeatTypeInAShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatTypeInAShowService {

    private SeatTypeInAShowRepository seatTypeInAShowRepository;

    @Autowired
    public SeatTypeInAShowService(SeatTypeInAShowRepository seatTypeInAShowRepository)
    {
        this.seatTypeInAShowRepository = seatTypeInAShowRepository;
    }

    public int calculatePrice(List<SeatInAShow> seatsInAShow)
    {
        int totalPrice = 0;

        for(SeatInAShow seat : seatsInAShow)
        {
            MovieShow currShow = seat.getMovieShow();
            SeatType currSeatType = seat.getSeat().getSeatType();

            SeatTypeInAShow currSeatTypeInAShow = seatTypeInAShowRepository.findByMovieShowAndSeatType(currShow , currSeatType);

            int priceForCurrSeat = currSeatTypeInAShow.getPrice();

            totalPrice += priceForCurrSeat;
        }

        return  totalPrice;
    }


}
