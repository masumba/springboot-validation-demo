package com.example.springbootvalidationdemo.services.interfaces;

import com.example.springbootvalidationdemo.models.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
  Reservation create(Reservation reservation);

  List<Reservation> findAll();

  Optional<Reservation> findByCode(String code);
}