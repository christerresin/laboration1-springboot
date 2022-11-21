package com.example.parkingspot;

import org.geolatte.geom.json.GeolatteGeomModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.parkingspot.entity.Car;
import com.example.parkingspot.entity.Event;
import com.example.parkingspot.entity.Person;
import com.example.parkingspot.entity.Zone;
import com.example.parkingspot.repository.CarRepository;
import com.example.parkingspot.repository.EventRepository;
import com.example.parkingspot.repository.PersonRepository;
import com.example.parkingspot.repository.ZoneRepository;

import static org.geolatte.geom.builder.DSL.*;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

import java.time.LocalDateTime;

import org.geolatte.geom.*;

@Configuration
public class ApplicationConfig {

  @Bean
  GeolatteGeomModule geomModule() {
    return new GeolatteGeomModule();
  }

  @Bean
  CommandLineRunner init(PersonRepository personRepository, CarRepository carRepository, ZoneRepository zoneRepository,
      EventRepository eventRepository) {
    return args -> {
      // DB inserts in here

      // Person inserts
      Person p1 = new Person();
      p1.setFirstName("Jessica");
      p1.setLastName("Jones");
      personRepository.save(p1);

      Person p2 = new Person();
      p2.setFirstName("Harley");
      p2.setLastName("Quinn");
      personRepository.save(p2);

      Person p3 = new Person();
      p3.setFirstName("James");
      p3.setLastName("West");
      personRepository.save(p3);

      Person p4 = new Person();
      p4.setFirstName("Keanu");
      p4.setLastName("Reaves");
      personRepository.save(p4);

      Person p5 = new Person();
      p5.setFirstName("Gwen");
      p5.setLastName("Stacey");
      personRepository.save(p5);

      Person p6 = new Person();
      p6.setFirstName("Kamala");
      p6.setLastName("Khan");
      personRepository.save(p6);

      Person p7 = new Person();
      p7.setFirstName("Neo");
      p7.setLastName("Andersson");
      personRepository.save(p7);

      // Car inserts
      Car c1 = new Car();
      c1.setRegistration("JEJ001");
      c1.setPerson(p1);
      carRepository.save(c1);

      Car c2 = new Car();
      c2.setRegistration("HAQ232");
      c2.setPerson(p2);
      carRepository.save(c2);

      Car c3 = new Car();
      c3.setRegistration("JAW556");
      c3.setPerson(p3);
      carRepository.save(c3);

      Car c4 = new Car();
      c4.setRegistration("KER110");
      c4.setPerson(p4);
      carRepository.save(c4);

      Car c5 = new Car();
      c5.setRegistration("GWS979");
      c5.setPerson(p5);
      carRepository.save(c5);

      Car c6 = new Car();
      c6.setRegistration("KAH371");
      c6.setPerson(p6);
      carRepository.save(c6);

      // Zone inserts
      Zone z1 = new Zone();
      z1.setName("Jarls Parkeringar");
      Point<G2D> pnt = point(WGS84, g(4.33, 53.21));
      z1.setCoordinate(pnt);
      zoneRepository.save(z1);

      Zone z2 = new Zone();
      z2.setName("Smurfit Gatuparkeringar");
      pnt = point(WGS84, g(-10, 52));
      z2.setCoordinate(pnt);
      zoneRepository.save(z2);

      Zone z3 = new Zone();
      z3.setName("Park Here AB");
      pnt = point(WGS84, g(10, 32));
      z3.setCoordinate(pnt);
      zoneRepository.save(z3);

      // Event inserts
      Event e1 = new Event();
      e1.setZone(z1);
      e1.setCar(c6);
      e1.setStart(LocalDateTime.now());
      e1.setStop(LocalDateTime.parse("2022-11-22T15:00:00"));
      eventRepository.save(e1);
    };
  }
}
