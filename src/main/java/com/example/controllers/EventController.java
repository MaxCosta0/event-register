package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Event;
import com.example.repository.EventRepository;

@Controller
public class EventController {
	
	@Autowired
	private EventRepository ev;
	
	@RequestMapping(value="/eventRegister", method=RequestMethod.GET)
	public String form() {
		return "event/eventForm";
	}
	
	@RequestMapping(value="/eventRegister", method=RequestMethod.POST)
	public String form(Event event) {
		ev.save(event);
		return "redirect:/eventRegister";
	}
	
	@RequestMapping("/events")
	public ModelAndView eventList() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Event> events = ev.findAll();
		mv.addObject("events", events);
		return mv;
	}
}