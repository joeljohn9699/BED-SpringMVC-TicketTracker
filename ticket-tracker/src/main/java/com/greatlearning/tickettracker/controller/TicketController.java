package com.greatlearning.tickettracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.tickettracker.entity.Ticket;
import com.greatlearning.tickettracker.service.TicketService;

@Controller
public class TicketController {

	@Autowired
	TicketService service;

	@GetMapping("/tickets")
	public String listTickets(Model model) {
		model.addAttribute("tickets", service.listAllTickets());
		return "tickets";

	}

	@GetMapping("/tickets/new")
	public String createTicket(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute(ticket);
		return "create_ticket";

	}

	@PostMapping("/saveticket")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		service.saveTicket(ticket);
		return "redirect:/tickets";

	}

	@GetMapping("/tickets/search")
	public String searchTicket(@RequestParam("query") String query, Model model) {
		List<Ticket> tickets = service.searchTicket(query);
		model.addAttribute("tickets", tickets);
		return "/tickets";

	}

	@GetMapping("/tickets/edit/{id}")
	public String editTicket(@PathVariable int id, Model model) {
		model.addAttribute("ticket", service.getTicketById(id));
		return "edit_ticket";
	}

	@PostMapping("/tickets/{id}")
	public String updateTicket(@PathVariable int id, @ModelAttribute("ticket") Ticket ticket, Model model) {

		Ticket existingTicket = service.getTicketById(id);
		existingTicket.setTitle(ticket.getTitle());
		existingTicket.setDescription(ticket.getDescription());

		service.updateTicket(existingTicket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable int id) {
		service.deleteTicketById(id);
		return "redirect:/tickets";

	}

	@GetMapping("/tickets/view/{id}")
	public String viewTicket(@PathVariable int id, Model model) {
		model.addAttribute("ticket", service.getTicketById(id));
		return "view_ticket";

	}

}
