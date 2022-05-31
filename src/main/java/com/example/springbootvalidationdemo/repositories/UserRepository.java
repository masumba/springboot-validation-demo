package com.example.springbootvalidationdemo.repositories;

import com.example.springbootvalidationdemo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}