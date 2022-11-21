package com.example.parkingspot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.parkingspot.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
  // @Query("SELECT e FROM Event e WHERE e.active = :active")
  // List<Event> findByActiveStatus(@Param("active") Boolean bool);

  @Query("SELECT e FROM Event e WHERE e.active = ?1")
  List<Event> findByActiveStatus(Boolean active);

  List<Event> findByActiveTrue();
}
