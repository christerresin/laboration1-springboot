package com.example.parkingspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.parkingspot.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
