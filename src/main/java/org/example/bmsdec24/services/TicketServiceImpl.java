package org.example.bmsdec24.services;

import org.example.bmsdec24.exceptions.InvalidUserException;
import org.example.bmsdec24.exceptions.SomeOrAllSeatsAreUnavailable;
import org.example.bmsdec24.models.*;
import org.example.bmsdec24.repos.ShowSeatRepository;
import org.example.bmsdec24.repos.TicketRepository;
import org.example.bmsdec24.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

    private UserRepository userRepository;

    private ShowSeatRepository showSeatRepository;

    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(UserRepository userRepository, ShowSeatRepository showSeatRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Ticket bookTicket(int userId, List<Integer> showSeatIds) throws InvalidUserException, SomeOrAllSeatsAreUnavailable {

        /*
        1. Check if the userId is valid, i.e. user is present in DB, if not throw exception
        2. Check if the showSeatIds are valid, else throw an exception
        3. Start the transaction
        4. Check if all the seats are available
        5. If yes, then set all the seat statuses to "BLOCKED" and user to the userId
        6. Generate the ticket
        7. store the ticket in db
        8. Return the ticket

         */
        User user = this.userRepository.findById(userId).orElseThrow(() -> new InvalidUserException("User not found"));
        List<ShowSeat> showSeats = this.showSeatRepository.findAllByIdInAndSeatStatus_Available(showSeatIds);
        if(showSeats.size() != showSeatIds.size()){
            //Write logic to calculate the exact seats that are blocked.
            throw new SomeOrAllSeatsAreUnavailable("Some/All seats are booked");
        }
        showSeats.forEach(showSeat -> {
            showSeat.setBookedBy(user);
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
        });
        showSeatRepository.saveAll(showSeats);
        // Create ticket
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        Show show = showSeats.get(0).getShow();
        ticket.setShow(show);
        ticket.setMovie(show.getMovie());
        ticket.setShowSeats(showSeats);
        ticket.setStatus(TicketStatus.PENDING);

        return this.ticketRepository.save(ticket);
    }
}
