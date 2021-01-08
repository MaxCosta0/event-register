package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Event;
import com.example.models.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, String>{
	Iterable<Participant> findByEvent(Event event);
}
