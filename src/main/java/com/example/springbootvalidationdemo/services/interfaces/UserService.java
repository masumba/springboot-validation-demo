package com.example.springbootvalidationdemo.services.interfaces;

import com.example.springbootvalidationdemo.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
  User create(User user);

  List<User> findAll();

  Optional<User> findById(int id);
}