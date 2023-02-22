package com.example.practice.controller;

import com.example.practice.DTO.EmployeeDto;
import com.example.practice.service.interfaces.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author Anh Dung
 *
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employee")
    public ResponseEntity<EmployeeDto> getEmployee(@RequestBody EmployeeDto employee){

        if(employee != null){
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
