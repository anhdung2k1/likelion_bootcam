package com.backend.memories.service.impl;

import org.springframework.stereotype.Service;

import com.backend.memories.repository.DemoRepository;
import com.backend.memories.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {
    private DemoRepository demoRepository;

    public DemoServiceImpl(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @Override
    public String getHelloWorld() {
        String getHelloString = demoRepository.getHelloWorld();
        return getHelloString;
    }
    
}
