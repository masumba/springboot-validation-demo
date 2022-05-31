package com.example.springbootvalidationdemo.repositories;

import com.example.springbootvalidationdemo.models.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
  Optional<Reservation> findFirstByOrderByIdDesc();

  Optional<Reservation> findByCode(String code);
}