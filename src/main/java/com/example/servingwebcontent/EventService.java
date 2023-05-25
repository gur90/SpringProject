package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class EventService {
    private EventRepository eventRepository;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    static final List<EventDTO> EVENT_DTOS = new ArrayList<EventDTO>() {{
        add(new EventDTO("violin concert", "Prague"));
        add(new EventDTO("jazz concert", "Berlin"));
        add(new EventDTO("art exibition", "London"));
        add(new EventDTO("opera", "London"));

    }};

    List<EventDTO> getEvents(String cityFilter) {
        Iterable<Event> allEvents = eventRepository.findAll();
        List<EventDTO> result = new ArrayList<EventDTO>();
        for (Event event : allEvents) {
            EventDTO eventDTO = new EventDTO(event.getName(), event.getCity());
            result.add(eventDTO);
        }
        return result;
    }

    public EventDTO getEvent(int id) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        Event event = eventOptional.get();
        EventDTO eventDTO = new EventDTO(event.getName(), event.getCity());
        return eventDTO;
    }

    public void deleteEvent(int id) {
        eventRepository.deleteById(id);

    }

    public EventDTO createEvent(EventDTO eventDTO) {
        String name = eventDTO.getName();
        String city = eventDTO.getCity();
        Event event = new Event();
        event.setName(name);
        event.setCity(city);
        eventRepository.save(event);
        return eventDTO;
    }

    public  void updateEvent(int id, EventDTO eventDTO) {
      Event event=eventRepository.findById(id).get();
      event.setName(eventDTO.getName());
      event.setCity(eventDTO.getCity());
      eventRepository.save(event);
    }

}
