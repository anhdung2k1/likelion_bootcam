package com.example.practice.service.impl;

import com.example.practice.DTO.EmployeeDto;
import com.example.practice.service.interfaces.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author Anh Dung
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public EmployeeDto getEmployeeDto(EmployeeDto employeeDto) {
        return employeeDto;
    }
}
