package com.jay.EventManager.Controller;

import com.jay.EventManager.DTOs.EventDTO;
import com.jay.EventManager.DTOs.UserDTO;
import com.jay.EventManager.Exceptions.EventNotFoundException;
import com.jay.EventManager.Exceptions.UserNotFoundException;
import com.jay.EventManager.Model.User;
import com.jay.EventManager.Repositories.UserRepo;
import com.jay.EventManager.Services.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;




    @GetMapping("/user/info")
    public ResponseEntity<UserDTO> getUserDetails(){
        String email =(String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepo.findById(email).get();

        return new ResponseEntity<UserDTO>(modelMapper.map(user, UserDTO.class), HttpStatus.OK);
    }

    @PutMapping("/user/update")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody User user)throws UserNotFoundException{
        UserDTO userDTO = userService.updateUser(user);

        return new ResponseEntity<UserDTO>(modelMapper.map(userDTO, UserDTO.class),HttpStatus.OK);
    }

    @GetMapping("/allEvent/{type}")
    public ResponseEntity<List<EventDTO>> getAllEventsByType(@PathVariable String type)throws EventNotFoundException
    {
        List<EventDTO> event = userService.getEventsByType(type);

        return new ResponseEntity<List<EventDTO>>(event, HttpStatus.OK);
    }

}
