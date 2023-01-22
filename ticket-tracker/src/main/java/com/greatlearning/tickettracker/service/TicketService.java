package com.greatlearning.tickettracker.service;

import java.util.List;

import com.greatlearning.tickettracker.entity.Ticket;

public interface TicketService {

	List<Ticket> listAllTickets();

	Ticket saveTicket(Ticket ticket);

	List<Ticket> searchTicket(String query);

	Ticket getTicketById(int id);

	Ticket updateTicket(Ticket ticket);

	void deleteTicketById(int id);

}
