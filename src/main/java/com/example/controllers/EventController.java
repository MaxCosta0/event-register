package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Event;
import com.example.models.Participant;
import com.example.repository.EventRepository;
import com.example.repository.ParticipantRepository;

@Controller
public class EventController {
	
	@Autowired
	private EventRepository er;
	
	@Autowired
	private ParticipantRepository pr;
	
	@RequestMapping(value="/eventRegister", method=RequestMethod.GET)
	public String form() {
		return "event/eventForm";
	}
	
	@RequestMapping(value="/eventRegister", method=RequestMethod.POST)
	public String form(Event event) {
		er.save(event);
		return "redirect:/eventRegister";
	}
	
	@RequestMapping("/events")
	public ModelAndView eventList() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Event> events = er.findAll();
		mv.addObject("events", events);
		return mv;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView eventDetails(@PathVariable("id") Long id) {
		Event event = er.findById(id);
		ModelAndView mv = new ModelAndView("event/eventDetails");
		mv.addObject("event", event);
		
		Iterable<Participant> participants = pr.findByEvent(event);
		mv.addObject("participants", participants);
		
		return mv;
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String eventDetailsPost(@PathVariable("id") Long id, Participant participant) {
		Event event = er.findById(id);
		participant.setEvent(event);
		pr.save(participant);
		return "redirect:/{id}";
	}
}