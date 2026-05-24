package com.example.bookmyshow_v1.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateTicketResponseDTO {

    private ResponseStatus status;
    private String message;
    private Long ticketId;

}
