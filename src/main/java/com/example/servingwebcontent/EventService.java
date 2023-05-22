package com.example.servingwebcontent;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Primary
public class EventService {
    static final List<EventDTO> EVENT_DTOS = new ArrayList<EventDTO>() {{
        add(new EventDTO("violin concert", "Prague"));
        add(new EventDTO("jazz concert", "Berlin"));
        add(new EventDTO("art exibition", "London"));
        add(new EventDTO("opera", "London"));

    }};

    List<EventDTO>getEvents(String cityFilter){
        List<EventDTO> results = EVENT_DTOS;
        if (!cityFilter.equals("all")) {
            results = EVENT_DTOS.stream().filter(e -> e.getCity().equals(cityFilter)).collect(Collectors.toList());
            // model.addAttribute("events", cityEvents);
        }
        return results;
    }
    public EventDTO getEvent(int id)
    {
        EventDTO eventDTO = EVENT_DTOS.get(id);
        return eventDTO;
    }

    public EventDTO deleteEvent(int id)
    {
        EventDTO eventDTO = EVENT_DTOS.get(id);
        // TODO: remove it from the database
        return eventDTO;
    }

    public EventDTO createEvent(EventDTO eventDTO)
    {
        // TODO save to database
        return eventDTO;
    }

    public EventDTO updateEvent(int id, EventDTO eventDTO)
    {
        EventDTO origEventDTO = EVENT_DTOS.get(id);
        // TODO: update event in the database
        //origEvent = event; // useless just for example
        return eventDTO;
    }

}