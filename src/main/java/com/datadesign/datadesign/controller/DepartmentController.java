package com.datadesign.datadesign.controller;

import com.datadesign.datadesign.ExceptionHandling.DepartmentNotFoundException;
import com.datadesign.datadesign.entity.Department;
import com.datadesign.datadesign.service.DepartmentService;
import com.datadesign.datadesign.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


 @PostMapping("/departments")
 public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
 }

 @GetMapping("/departments")
 public List<Department> fetchDeptList(){
        LOGGER.info("Inside fetchDeptList of DepartmentController");
        return departmentService.fetchDepartmentList();
 }

 @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
 }
 @DeleteMapping("/departments/{id}")
 public String deleteDepartmentById(@PathVariable("id")Long departmentId){
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Department Successfilly";
 }
 @PutMapping("/departments/{id}")
 public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        LOGGER.info("Inside updateDepartment of DepartmentController");
        return departmentService.updateDepartment(departmentId,department);
 }

 @GetMapping("/departments/name/{name}")
 public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside fetchDepartmentByName of DepartmentController");
        return departmentService.fetchDepartmentByName(departmentName);
 }
}
