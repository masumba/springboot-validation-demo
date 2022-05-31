package com.example.springbootvalidationdemo.repositories;

import com.example.springbootvalidationdemo.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}