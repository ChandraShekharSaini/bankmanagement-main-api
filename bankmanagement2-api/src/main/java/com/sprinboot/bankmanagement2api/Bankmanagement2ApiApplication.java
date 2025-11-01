package com.sprinboot.bankmanagement2api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Bankmanagement2ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Bankmanagement2ApiApplication.class, args);
    }

}
