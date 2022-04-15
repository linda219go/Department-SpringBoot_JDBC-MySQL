package com.dailycode.SB.controller;

import com.dailycode.SB.entity.Department;
import com.dailycode.SB.error.DptmtNotFoundException;
import com.dailycode.SB.service.DepartmentService;
import com.dailycode.SB.service.DepartmentServiceImpl;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid  @RequestBody Department deptmt){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(deptmt);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchdepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long dptId) throws DptmtNotFoundException {
        return departmentService.fetchDepartmentById(dptId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long dptmtId){
        departmentService.deleteDepartmentById(dptmtId);
        return "Department deleted";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long dptmtId, @RequestBody Department dptmt){
        return departmentService.updateDepartment(dptmtId,dptmt);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String dptName){
        return departmentService.fetchDepartmentByName(dptName);
    }

}
