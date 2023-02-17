package com.example.practice.controller;

import com.example.practice.DTO.DepartmentDto;
import com.example.practice.DTO.EmployeeDto;
import com.example.practice.service.interfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Anh Dung
 *
 */

@RestController
@RequestMapping("/api")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/department")
    public ResponseEntity<DepartmentDto> getDepartment(@RequestBody DepartmentDto departmentDto){
        List<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>();
        EmployeeDto employeeDto_1 = new EmployeeDto(1L,"Anh Dũng", new Date(2001,9,11), "Male", "kudung053@gmail.com");
        EmployeeDto employeeDto_2 = new EmployeeDto(2L,"Anh Kiệt", new Date(2002,2,14), "Male", "anhkiet@gmail.com");
        employeeDtoList.add(employeeDto_1);
        employeeDtoList.add(employeeDto_2);

        DepartmentDto departmentDtoData = new DepartmentDto(departmentDto.getDepartmentId(),departmentDto.getDeptName(),departmentDto.getDescription(),employeeDtoList);
        if(departmentDtoData != null){
            return new ResponseEntity<>(departmentDtoData, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
