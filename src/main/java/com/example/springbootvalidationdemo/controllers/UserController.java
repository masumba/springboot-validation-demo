package com.example.springbootvalidationdemo.controllers;

import com.example.springbootvalidationdemo.models.User;
import com.example.springbootvalidationdemo.models.dtos.RegisterUserDto;
import com.example.springbootvalidationdemo.services.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping(value = "/user")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody RegisterUserDto registerUserDto) {
        User createdUser = userService.create(registerUserDto.toUser());

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> allUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
}