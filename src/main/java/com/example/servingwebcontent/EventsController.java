package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Event {
    public Event(String name, String city) {
        this.name = name;
        this.city = city;
    }

    private String name;
    private String city;

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}

@RestController
public class EventsController {

    static final List<Event> events = new ArrayList<Event>() {{
        add(new Event("violin concert", "Prague"));
        add(new Event("jazz concert", "Berlin"));
        add(new Event("art exibition", "London"));
        add(new Event("opera", "London"));

    }};


   // @RequestMapping(value = "/events", method = RequestMethod.GET)
   // @ResponseBody
@GetMapping(value = "/events")
    public List<Event> listEvents(@RequestParam(name = "city", required = false, defaultValue = "all") String city) {
        List<Event> results = events;

        if (!city.equals("all")) {

            results = events.stream().filter(e -> e.getCity().equals(city)).collect(Collectors.toList());
            // model.addAttribute("events", cityEvents);
        }

        return results;
    }

   // @RequestMapping(value="/events/{eventId}", method = RequestMethod.GET)
   // @ResponseBody
    @GetMapping(value="/events/{eventId}")
    public Event getEvent(@PathVariable int eventId){
        Event event=events.get(eventId);
        return event;
    }
   // @RequestMapping(value="/events/{eventId}", method = RequestMethod.DELETE)
   // @ResponseBody
    @DeleteMapping(value="/events/{eventId}")
    public Event deleteEvent(@PathVariable int eventId){
        Event event=events.get(eventId);
        return event;
    }
    @PutMapping(value="/events/{eventId}")
    public Event updateEvent(@PathVariable int eventId, @RequestBody Event newEvent)
    {
        Event event = events.get(eventId);
        // TODO: update event in database
        event = newEvent; // useless. just for example
        return event;
    }
}
