package com.example.springbootvalidationdemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.springbootvalidationdemo.models.Address;
import com.example.springbootvalidationdemo.models.User;
import com.example.springbootvalidationdemo.repositories.AddressRepository;
import com.example.springbootvalidationdemo.repositories.UserRepository;
import com.example.springbootvalidationdemo.services.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public User create(User user) {
        Address persistedAddress = addressRepository.save(user.getAddress());

        user.setAddress(persistedAddress);

        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return users;
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }
}
