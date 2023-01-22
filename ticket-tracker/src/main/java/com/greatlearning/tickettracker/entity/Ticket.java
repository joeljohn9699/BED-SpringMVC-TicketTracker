package com.greatlearning.tickettracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "Ticket Title")
	String title;

	@Column(name = "Ticket Description")
	String description;

	@Column(name = "Ticket Created on", nullable = false)
	String date;

}
