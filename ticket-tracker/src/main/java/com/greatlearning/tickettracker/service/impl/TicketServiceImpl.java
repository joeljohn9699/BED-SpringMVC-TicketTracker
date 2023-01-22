package com.greatlearning.tickettracker.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.tickettracker.entity.Ticket;
import com.greatlearning.tickettracker.repository.TicketRepository;
import com.greatlearning.tickettracker.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository repository;

	@Override
	public List<Ticket> listAllTickets() {
		return repository.findAll();
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return repository.save(ticket);
	}

	@Override
	public List<Ticket> searchTicket(String query) {
		List<Ticket> tickets = repository.searchTickets(query);
		return tickets.stream().collect(Collectors.toList());
	}

	@Override
	public Ticket getTicketById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		return repository.save(ticket);
	}

	@Override
	public void deleteTicketById(int id) {
		repository.deleteById(id);

	}

}
