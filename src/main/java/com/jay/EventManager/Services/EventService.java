package com.jay.EventManager.Services;

import com.jay.EventManager.DTOs.EventDTO;
import com.jay.EventManager.Exceptions.EventNotFoundException;

public interface EventService {
    public EventDTO createEvent(EventDTO eventDTO);

    public EventDTO updateEvent(Long eventId, EventDTO eventDTO) throws EventNotFoundException;

    public String deleteEvent(Long eventId) throws EventNotFoundException;
}
