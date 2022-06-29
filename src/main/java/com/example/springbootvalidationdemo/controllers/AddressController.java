package com.example.springbootvalidationdemo.controllers;

import com.example.springbootvalidationdemo.exceptions.ResourceNotFoundException;
import com.example.springbootvalidationdemo.models.Address;
import com.example.springbootvalidationdemo.services.interfaces.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/addresses")
@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("")
    public ResponseEntity<List<Address>> allAddresses() {
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> oneAddress(@PathVariable Integer id) throws ResourceNotFoundException {
        Optional<Address> optionalAddress = addressService.findById(id);
        if (!optionalAddress.isPresent()) {
            throw new ResourceNotFoundException("No Address found with reference id: " + id);
        }
        return new ResponseEntity<>(optionalAddress.get(), HttpStatus.OK);
    }
}
