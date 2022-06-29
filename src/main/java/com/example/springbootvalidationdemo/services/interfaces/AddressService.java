package com.example.springbootvalidationdemo.services.interfaces;

import com.example.springbootvalidationdemo.models.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> findAll();

    Optional<Address> findById(Integer id);
}
