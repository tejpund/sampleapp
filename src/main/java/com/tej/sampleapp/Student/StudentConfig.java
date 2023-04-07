package com.tej.sampleapp.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Configuration
public class StudentConfig {
  @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
    return args ->{
      Student tej =new Student(
            1L,
            "Tej",
            "Pund",
            "tej@gmail.com",
            60
    );
      Student chiu=new Student(
              2L,
              "Chiu",
              "Kaware",
              "chiu@gmail.com",
              7
      );
      repository.saveAll(List.of(tej,chiu));
    };

    }



}
