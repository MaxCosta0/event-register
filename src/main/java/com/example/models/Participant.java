package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Participant{
	
	@Id
	@NotNull
	private Long cpf;
	
	@Column
	@NotEmpty
	private String participantName;
	
	@ManyToOne
	private Event event;
	
	public Participant() {
		
	}

	public Participant(Long cpf, String participantName, Event event) {
		this.cpf = cpf;
		this.participantName = participantName;
		this.event = event;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
}
