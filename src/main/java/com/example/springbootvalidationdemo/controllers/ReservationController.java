package com.example.springbootvalidationdemo.controllers;

import com.example.springbootvalidationdemo.exceptions.ResourceNotFoundException;
import com.example.springbootvalidationdemo.models.Reservation;
import com.example.springbootvalidationdemo.models.User;
import com.example.springbootvalidationdemo.models.dtos.CreateReservationDto;
import com.example.springbootvalidationdemo.services.interfaces.ReservationService;
import com.example.springbootvalidationdemo.services.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;

@Validated
@RequestMapping(value = "/reservations")
@RestController
public class ReservationController {
    private final ReservationService reservationService;

    private final UserService userService;

    public ReservationController(ReservationService reservationService, UserService userService) {
        this.reservationService = reservationService;
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody CreateReservationDto createReservationDto)
            throws ResourceNotFoundException {
        Optional<User> optionalUser = userService.findById(createReservationDto.getUserId());

        if (!optionalUser.isPresent()) {
            throw new ResourceNotFoundException("No user found with the Id: " + createReservationDto.getUserId());
        }

        Reservation reservationInput = createReservationDto.toReservation().setUser(optionalUser.get());

        Reservation createdReservation = reservationService.create(reservationInput);

        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Reservation>> allReservations() {
        return new ResponseEntity<>(reservationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Reservation> oneReservation(
            @Pattern(regexp = "^RSV(-\\d{4,}){2}$", message = "The reservation code is invalid") @PathVariable String code
    ) throws ResourceNotFoundException {
        Optional<Reservation> optionalReservation = reservationService.findByCode(code);

        if (!optionalReservation.isPresent()) {
            throw new ResourceNotFoundException("No reservation found with the code: " + code);
        }

        return new ResponseEntity<>(optionalReservation.get(), HttpStatus.OK);
    }
}
