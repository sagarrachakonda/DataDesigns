package com.datadesign.datadesign.controller;

import com.datadesign.datadesign.entity.Department;
import com.datadesign.datadesign.service.DepartmentService;
import com.datadesign.datadesign.service.DepartmentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


 @PostMapping("/departments")
 public Department saveDepartment(@RequestBody Department department){
     return departmentService.saveDepartment(department);
 }

 @GetMapping("/departments")
 public List<Department> fetchDeptList(){
     return departmentService.fetchDepartmentList();
 }

 @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);
 }
 @DeleteMapping("/departments/{id}")
 public String deleteDepartmentById(@PathVariable("id")Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Department Successfilly";
 }
 @PutMapping("/departments/{id}")
 public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
 }
}
