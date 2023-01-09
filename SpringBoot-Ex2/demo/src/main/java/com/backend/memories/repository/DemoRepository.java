package com.backend.memories.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {
    public String getHelloWorld(){
        return "Hello World";
    }
}
