package com.datadesign.datadesign.service;

import com.datadesign.datadesign.ExceptionHandling.DepartmentNotFoundException;
import com.datadesign.datadesign.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);

    public Department findByDepartmentNameandAddress(String departmentName,String Address);


}
