package com.example.servingwebcontent;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "About events")
@RestController
@RequestMapping("events")
public class EventsController {

    static final List<Event> events = new ArrayList<Event>() {{
        add(new Event("violin concert", "Prague"));
        add(new Event("jazz concert", "Berlin"));
        add(new Event("art exibition", "London"));
        add(new Event("opera", "London"));

    }};

    @Operation(summary = "Get all events", description = "Get all events filtered by city")
    // @RequestMapping(value = "/events", method = RequestMethod.GET)
    // @ResponseBody
    @GetMapping(value = "")
    public List<Event> listEvents(@RequestParam(name = "city", required = false, defaultValue = "all") String city) {
        List<Event> results = events;

        if (!city.equals("all")) {

            results = events.stream().filter(e -> e.getCity().equals(city)).collect(Collectors.toList());
            // model.addAttribute("events", cityEvents);
        }

        return results;
    }
    @Operation(summary = "Get  events by id", description = "Get events filtered by id")
    // @RequestMapping(value="/events/{eventId}", method = RequestMethod.GET)
    // @ResponseBody
    @GetMapping(value = "/{eventId}")
    public Event getEvent(@PathVariable int eventId) {
        Event event = events.get(eventId);
        return event;
    }
    @Operation(summary = "Delete events by id", description = "Delete events by  id")
    // @RequestMapping(value="/events/{eventId}", method = RequestMethod.DELETE)
    // @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "something is going bad")
    @DeleteMapping(value = "/{eventId}")
    public Event deleteEvent(@PathVariable int eventId) {
        Event event = events.get(eventId);
        return event;
    }
    @Operation(summary = "Put events", description = "Put new event")
    @PutMapping(value = "/{eventId}")
    public Event updateEvent(@PathVariable int eventId, @RequestBody Event newEvent) {
        Event event = events.get(eventId);
        // TODO: update event in database
        event = newEvent; // useless. just for example
        return event;
    }
}
