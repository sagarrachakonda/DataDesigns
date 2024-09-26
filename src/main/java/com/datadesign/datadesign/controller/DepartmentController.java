package com.datadesign.datadesign.controller;

import com.datadesign.datadesign.ExceptionHandling.DepartmentNotFoundException;
import com.datadesign.datadesign.SqlQueries.DepartmentQueries;
import com.datadesign.datadesign.entity.Department;
import com.datadesign.datadesign.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private DepartmentService departmentService;
    private DepartmentQueries queries;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    public DepartmentController(DepartmentService departmentService, DepartmentQueries queries) {
        this.departmentService = departmentService;
        this.queries = queries;
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
        return "Deleted Department Successfully";
 }
 @PutMapping("/departments/{id}")
 public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        LOGGER.info("Inside updateDepartment of DepartmentController");
        return departmentService.updateDepartment(departmentId,department);
 }

 @GetMapping("/departments/name/{name}")
 public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside fetchDepartmentByName of DepartmentController"+"---------"+queries.departmentbyname);
        return departmentService.fetchDepartmentByName(departmentName);
 }

 @GetMapping("/departments/nameadd/{name}/{address}")
 public Department fetchDepartmentByNameAndAddress(@PathVariable("name") String departmentName, @PathVariable("address") String Address){
        LOGGER.info("Entered fetchDepartmentByNameAndAddress method"+"---------"+queries.departmentbynameandaddress);
        return departmentService.findByDepartmentNameandAddress(departmentName,Address);
 }

}
