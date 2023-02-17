package com.example.practice.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Anh Dung
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    @NotNull(message = "Department ID is null")
    private Long departmentId;
    @NotEmpty(message = "DeptName is null")
    @Size(min = 10, max = 50)
    private String deptName;
    @NotEmpty(message = "Description is null")
    private String description;
    @Valid
    private List<EmployeeDto> employeeDtoList;
}
