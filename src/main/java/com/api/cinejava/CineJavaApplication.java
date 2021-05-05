package com.api.cinejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class CineJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CineJavaApplication.class, args);
        System.out.print(new BCryptPasswordEncoder().encode("123"));
    }


}
