package com.backend.memories.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.memories.service.DemoService;

@RestController
public class DemoController {
    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping(value = "/")
    public String getDemoHelloString(){
        return demoService.getHelloWorld();
    }
}
