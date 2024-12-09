package org.example.bmsdec24;

import org.example.bmsdec24.controllers.UserController;
import org.example.bmsdec24.dtos.SignupRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BmsDec24Application implements CommandLineRunner {

    @Autowired
    private UserController userController;


    public static void main(String[] args) {
        SpringApplication.run(BmsDec24Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SignupRequestDto requestDto = new SignupRequestDto();
        requestDto.setEmail("john@doe4.com");
        requestDto.setPassword("123456789");
        requestDto.setName("John Doe");
        userController.signUp(requestDto);
    }
}
