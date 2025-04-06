package com.jay.EventManager.Services;

import com.jay.EventManager.DTOs.EventDTO;
import com.jay.EventManager.DTOs.UserDTO;
import com.jay.EventManager.Exceptions.EventNotFoundException;
import com.jay.EventManager.Exceptions.UserNotFoundException;
import com.jay.EventManager.Model.User;

import java.util.List;

public interface UserService {

    UserDTO registerUser(User user) throws UserNotFoundException;

    UserDTO updateUser(User user) throws UserNotFoundException;

    List<EventDTO> getEventsByType(String eventType) throws EventNotFoundException;
}

