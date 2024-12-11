package org.example.bmsdec24.services;

import org.example.bmsdec24.exceptions.InvalidUserException;
import org.example.bmsdec24.exceptions.SomeOrAllSeatsAreUnavailable;
import org.example.bmsdec24.models.Ticket;

import java.util.List;

public interface TicketService {

    public Ticket bookTicket(int userId, List<Integer> showSeatId) throws InvalidUserException, SomeOrAllSeatsAreUnavailable;
}
