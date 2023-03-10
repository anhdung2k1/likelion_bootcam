package org.example.driver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/driver")
public class DriverController {
    @GetMapping("taxi")
    public String getTaxi(){
        return "You found a taxi, the taxi is comming!";
    }
}
