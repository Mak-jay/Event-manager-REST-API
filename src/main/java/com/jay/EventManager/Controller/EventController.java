package com.jay.EventManager.Controller;

import com.jay.EventManager.DTOs.EventDTO;
import com.jay.EventManager.Exceptions.EventNotFoundException;
import com.jay.EventManager.Model.Event;
import com.jay.EventManager.Services.EventService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event")
@SecurityRequirement(name = "Event Manager")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO){
        EventDTO createEvent = eventService.createEvent(eventDTO);

        return new ResponseEntity<EventDTO>(createEvent,HttpStatus.CREATED);
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long eventId,@RequestBody EventDTO eventDTO)
    throws EventNotFoundException {
        EventDTO updatedEvent = eventService.updateEvent(eventId,eventDTO);

        return new ResponseEntity<EventDTO>(updatedEvent,HttpStatus.CREATED);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long eventId) throws EventNotFoundException {
        String response = eventService.deleteEvent(eventId);

        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }
}
