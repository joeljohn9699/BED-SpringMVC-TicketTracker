package com.greatlearning.tickettracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.tickettracker.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	@Query("SELECT t FROM Ticket t WHERE CONCAT(t.title, ' ', t.description, ' ') LIKE %?1%")
	public List<Ticket> searchTickets(String query);

}
