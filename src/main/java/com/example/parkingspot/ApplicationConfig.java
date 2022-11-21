package com.example.parkingspot;

import org.geolatte.geom.json.GeolatteGeomModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.parkingspot.repository.PersonRepository;

@Configuration
public class ApplicationConfig {

  @Bean
  GeolatteGeomModule geomModule() {
    return new GeolatteGeomModule();
  }

  @Bean
  CommandLineRunner init(PersonRepository personRepository) {
    return args -> {
      // DB inserts in here
    };
  }
}
