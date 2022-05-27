package kell.hotel.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"kell.hotel.*"})
@EnableJpaRepositories(value = "kell.hotel.repository")
@EntityScan(value = "kell.hotel.model")
public class HotelApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
    }
}
