package com.example.servingwebcontent.event;

import com.example.servingwebcontent.place.Place;
import com.example.servingwebcontent.place.PlaceRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class EventService {
    private EventRepository eventRepository;
    private PlaceRepository placeRepository;

    @Autowired
    public void setPlaceRepository(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }



    List<EventDTO> getEvents(String cityFilter) {
        List<Event>allEvents =eventRepository.findAll();
        List<EventDTO> result=modelMapper.map(allEvents,new TypeToken<List<EventDTO>>(){}.getType());
        return result;

    }

    public EventDTO getEvent(int id) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        Event event = eventOptional.get();
        //EventDTO eventDTO = new EventDTO(event.getName(), event.getCity());

        EventDTO eventDTO = modelMapper.map(event, EventDTO.class);
        return eventDTO;
    }

    public void deleteEvent(int id) {
        eventRepository.deleteById(id);

    }

    public int createEvent(NewEventDTO newEventDTO) {
        int placeId = newEventDTO.getPlaceId();
        Place place = placeRepository.findById(placeId).get();
        Event event = new Event();
        event.setName(newEventDTO.getName());
        event.setPlace(place);
        return eventRepository.save(event).getId();

    }

//    public EventDTO createEvent(EventDTO eventDTO) {
//
//       Event event= modelMapper.map(eventDTO,Event.class);
////        String name = eventDTO.getName();
////        String city = eventDTO.getCity();
////        Event event = new Event();
////        event.setName(name);
////        event.setCity(city);
//        eventRepository.save(event);
//        return eventDTO;
//    }

    public void updateEvent(int id, NewEventDTO eventDTO) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        Event event = eventOptional.get();
        event.setName(eventDTO.getName());
        Place place = placeRepository.findById(eventDTO.getPlaceId()).get();

        event.setPlace(place);
        eventRepository.save(event);

    }

    public List<EventDTO> getEventsByPlace(int placeId) {
        Place place = placeRepository.findById(placeId).get();
        List<Event> eventsForPlace = place.getEvents();
        List<EventDTO> result = modelMapper.map(eventsForPlace, new TypeToken<List<EventDTO>>() {
        }.getType());
return result;
    }

}
