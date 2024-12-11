package org.example.bmsdec24.controllers;

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
    public Ticket bookTicket(List<Integer> showSeatIds, int userId){
        try{
            Ticket ticket = ticketService.bookTicket(userId, showSeatIds);
            return ticket;
        } catch (Exception e) {
            return null;
        }

    }
}
