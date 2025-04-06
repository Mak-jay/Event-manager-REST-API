package com.jay.EventManager.Repositories;

import com.jay.EventManager.DTOs.EventDTO;
import com.jay.EventManager.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event,Long> {
    @Query("SELECT e FROM Event e WHERE e.eventType = :eventType")
    List<Event> findByEventType(String email, String eventType);
}
