package com.carparking;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.carparking.*"})
@SpringBootApplication
public class CarParkingApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(CarParkingApplication.class, args);
    }
}
