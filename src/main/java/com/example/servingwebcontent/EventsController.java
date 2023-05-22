package com.example.servingwebcontent;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "About events")
@RestController
@RequestMapping("events")
public class EventsController {
private EventService service;
@Autowired
    public void setService(EventService service) {
        this.service = service;
    }

    @Operation(summary = "Get all events", description = "Get all events filtered by city")
    // @RequestMapping(value = "/events", method = RequestMethod.GET)
    // @ResponseBody
    @GetMapping(value = "")
    public List<EventDTO> listEvents(@RequestParam(name = "city", required = false, defaultValue = "all") String city) {


        return service.getEvents(city);
    }
    @Operation(summary = "Get  events by id", description = "Get events filtered by id")
    // @RequestMapping(value="/events/{eventId}", method = RequestMethod.GET)
    // @ResponseBody
    @GetMapping(value = "/{eventId}")
    public EventDTO getEvent(@PathVariable int eventId) {
        EventDTO eventDTO = service.getEvent(eventId);
        return eventDTO;
    }
    @Operation(summary = "Delete events by id", description = "Delete events by  id")
    // @RequestMapping(value="/events/{eventId}", method = RequestMethod.DELETE)
    // @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "something is going bad")
    @DeleteMapping(value = "/{eventId}")
    public EventDTO deleteEvent(@PathVariable int eventId) {
        EventDTO eventDTO = service.deleteEvent(eventId);
        return eventDTO;
    }
    @Operation(summary = "Put events", description = "Put new event")
    @PutMapping(value = "/{eventId}")
    public EventDTO updateEvent(@PathVariable int eventId, @RequestBody EventDTO newEventDTO) {
        EventDTO eventDTO = service.updateEvent(eventId, newEventDTO);
        // TODO: update event in database
        eventDTO = newEventDTO; // useless. just for example
        return eventDTO;
    }
}