package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Event;

public interface EventRepository extends CrudRepository<Event, String> {

}
