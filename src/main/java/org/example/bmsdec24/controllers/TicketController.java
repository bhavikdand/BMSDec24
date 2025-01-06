package org.example.bmsdec24.controllers;

import org.example.bmsdec24.dtos.BookTicketRequestDto;
import org.example.bmsdec24.dtos.SignupRequestDto;
import org.example.bmsdec24.exceptions.InvalidBookTicketRequestException;
import org.example.bmsdec24.exceptions.InvalidUserException;
import org.example.bmsdec24.exceptions.SomeOrAllSeatsAreUnavailable;
import org.example.bmsdec24.models.Ticket;
import org.example.bmsdec24.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    //Create a dto for request params and response params
    public Ticket bookTicket(BookTicketRequestDto requestDto){
        try{
            validateBookTicketRequestDto(requestDto);
            Ticket ticket = ticketService.bookTicket(requestDto.getUserId(), requestDto.getShowSeatIds());
            return ticket;
        } catch (Exception e){
            return null;
        }

    }

    private void validateBookTicketRequestDto(BookTicketRequestDto requestDto) throws InvalidBookTicketRequestException {
        if(requestDto.getUserId() <= 0){
            throw new InvalidBookTicketRequestException("User id cannot be negative");
        }

        if(requestDto.getShowSeatIds() == null || requestDto.getShowSeatIds().isEmpty()){
            throw new InvalidBookTicketRequestException("Show seat ids cannot be empty");
        }
    }
}
