package com.example.bookmyshow_v1.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenerateTicketRequestDTO {

    private List<Long> seatInAShowIds;
    private Long userId;

}
