package com.example.bookmyshow_v1.services;

import com.example.bookmyshow_v1.exceptions.SeatNotAvailableException;
import com.example.bookmyshow_v1.exceptions.UserNotFoundException;
import com.example.bookmyshow_v1.models.AppUser;
import com.example.bookmyshow_v1.models.Enums.SeatStatus;
import com.example.bookmyshow_v1.models.SeatInAShow;
import com.example.bookmyshow_v1.models.Ticket;
import com.example.bookmyshow_v1.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {


    private TicketRepository ticketRepository;
    private SeatInAShowService seatInAShowService;
    private AppUserService appUserService;
    private SeatTypeInAShowService seatTypeInAShowService;

    @Autowired
    public TicketService(TicketRepository ticketRepository , SeatInAShowService seatInAShowService , AppUserService appUserService ,SeatTypeInAShowService  seatTypeInAShowService)
    {
        this.ticketRepository = ticketRepository;
        this.seatInAShowService = seatInAShowService;
        this.appUserService = appUserService;
        this.seatTypeInAShowService = seatTypeInAShowService;

    }

    public Ticket generateTicket(List<Long> seatInShowIds , Long userId) throws SeatNotAvailableException , UserNotFoundException
    {
        List<SeatInAShow> seatsInAShow = seatInAShowService.findSeatsById(seatInShowIds);

        Date currTime = new Date();
        for(SeatInAShow seat : seatsInAShow)
        {
            if(!isAvailable(seat , currTime))
            {
                throw new SeatNotAvailableException();
            }
        }

        AppUser user = appUserService.getUserById(userId);

        if(user == null)
        {
            throw new UserNotFoundException();
        }


        List<SeatInAShow> updatedSeats = seatInAShowService.lockSeats(seatsInAShow , currTime);

        int ticketPrice = seatTypeInAShowService.calculatePrice(updatedSeats);

        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setPayment(null);
        ticket.setBookingTime(currTime);
        ticket.setSeatsBooked(updatedSeats);
        ticket.setAmount(ticketPrice);
        Ticket dummyTicket = ticketRepository.save(ticket);

        return dummyTicket;
    }

    private boolean isAvailable(SeatInAShow seatInShow , Date currTime)
    {
        if(seatInShow.getSeatStatus().equals(SeatStatus.Available)) return true;

        if(seatInShow.getSeatStatus().equals(SeatStatus.Locked))
        {
            long lockedAtInMillis = seatInShow.getLockedAt().getTime();
            long currentTimeInMillis = currTime.getTime();
            long lockingTimeOutInMillis = seatInShow.getMovieShow().getLockingTimeout() * 60 * 1000L;

            return (currentTimeInMillis - lockedAtInMillis) > lockingTimeOutInMillis;
        }

        return false;

    }



}
