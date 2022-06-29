package com.example.springbootvalidationdemo.services;

import com.example.springbootvalidationdemo.models.Address;
import com.example.springbootvalidationdemo.repositories.AddressRepository;
import com.example.springbootvalidationdemo.services.interfaces.AddressService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        List<Address> addresses = new ArrayList<>();

        addressRepository.findAll().forEach(addresses::add);

        return addresses;
    }

    @Override
    public Optional<Address> findById(Integer id) {
        return addressRepository.findById(id);
    }
}
