package com.example.bookmyshow_v1.controllers;

import com.example.bookmyshow_v1.dtos.GenerateTicketRequestDTO;
import com.example.bookmyshow_v1.dtos.GenerateTicketResponseDTO;
import com.example.bookmyshow_v1.dtos.ResponseStatus;
import com.example.bookmyshow_v1.models.Ticket;
import com.example.bookmyshow_v1.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService)
    {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDTO bookTicket(GenerateTicketRequestDTO generateTicketRequestDTO)
    {
        GenerateTicketResponseDTO responseDTO = new GenerateTicketResponseDTO();

        try {
            Ticket dummtTicket = ticketService.generateTicket(generateTicketRequestDTO.getSeatInAShowIds() , generateTicketRequestDTO.getUserId());
            responseDTO.setTicketId(dummtTicket.getId());
            responseDTO.setStatus(ResponseStatus.Success);
            responseDTO.setMessage("Successfully booked selected Seats , Please Proceed to Payment Gateway");

        }catch (Exception e)
        {
            responseDTO.setStatus(ResponseStatus.Failure);
            responseDTO.setMessage("Something went wrong, Please try again in some time ");
        }

        return responseDTO;
    }

}
