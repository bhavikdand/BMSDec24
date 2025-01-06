package org.example.bmsdec24.controllers;


import org.example.bmsdec24.dtos.BookTicketRequestDto;
import org.example.bmsdec24.exceptions.InvalidUserException;
import org.example.bmsdec24.models.Ticket;
import org.example.bmsdec24.services.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class TicketControllerTest {

    /*
    Scenarios:
    Positive scenario: Ticket gets booked
    Negative scenarios:
    1. userId -ve or 0
    2. showSeats array is null TODO: Homework
    3. empty show seats array TODO: Homework
    4. dto object has correct data, but the service fails and give some exception

     */

    @Autowired
    private TicketController ticketController;

    @MockBean
    private TicketService ticketService;


    @Test
    public void testBookTicket_NegativeUserId() throws Exception{
        //Arrange
        BookTicketRequestDto requestDto = new BookTicketRequestDto();
        requestDto.setUserId(-10);
        requestDto.setShowSeatIds(List.of(1,2,3));

        when(ticketService.bookTicket(requestDto.getUserId(), requestDto.getShowSeatIds()))
                .thenThrow(InvalidUserException.class); // Is only applicable for the current test
//                .thenReturn(new Ticket());
        //Act
        Ticket ticket = ticketController.bookTicket(requestDto);

        //Assert
        assertNull(ticket, "Ticket should be null here");
    }

    @Test
    public void testBookTicket_ZeroUserId() throws Exception{
        //Arrange
        BookTicketRequestDto requestDto = new BookTicketRequestDto();
        requestDto.setUserId(0);
        requestDto.setShowSeatIds(List.of(1,2,3));

        when(ticketService.bookTicket(requestDto.getUserId(), requestDto.getShowSeatIds()))
                .thenThrow(InvalidUserException.class); // Is only applicable for the current test
//                .thenReturn(new Ticket());
        //Act
        Ticket ticket = ticketController.bookTicket(requestDto);

        //Assert
        assertNull(ticket, "Ticket should be null here");
    }

    @Test
    public void testBookTicket_TicketServiceFails_ThrowsInvalidUserException() throws Exception{
        //Arrange
        BookTicketRequestDto requestDto = new BookTicketRequestDto();
        requestDto.setUserId(10);
        requestDto.setShowSeatIds(List.of(1,2,3));
        when(ticketService.bookTicket(requestDto.getUserId(), requestDto.getShowSeatIds()))
                .thenThrow(InvalidUserException.class);

        //Act
        Ticket ticket = ticketController.bookTicket(requestDto);

        //Assert
        assertNull(ticket, "Ticker should be null");
    }

    @Test
    public void testBookTicker_PositiveScenario() throws Exception{
        //Arrange
        BookTicketRequestDto requestDto = new BookTicketRequestDto();
        requestDto.setUserId(10);
        requestDto.setShowSeatIds(List.of(1,2,3));

        Ticket ticket = new Ticket();
        ticket.setMovie(null);
        ticket.setShow(null);
        ticket.setId(1);

        when(ticketService.bookTicket(requestDto.getUserId(), requestDto.getShowSeatIds()))
                .thenReturn(ticket);
//                .thenReturn(new Ticket());

        //Act
        Ticket actualTicket = ticketController.bookTicket(requestDto);

        //Assert
        assertNotNull(actualTicket, "Ticket should be not null");
        assertEquals(1, actualTicket.getId(), "Id of the ticket should be 1");
    }

}