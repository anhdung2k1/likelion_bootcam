package com.example.practice.service.impl;

import com.example.practice.DTO.DepartmentDto;
import com.example.practice.service.interfaces.DepartmentService;
import org.springframework.stereotype.Service;
/**
 * @author Anh Dung
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public DepartmentDto getDepartmentDto(DepartmentDto departmentDto) {
        return departmentDto;
    }
}
