package com.datadesign.datadesign.service;

import com.datadesign.datadesign.Repository.DepartmentRepo;
import com.datadesign.datadesign.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentRepo departmentRepo;

    public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }


    @Override
    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepo.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepo.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepo.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department deptDB = departmentRepo.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmantName()) && !"".equalsIgnoreCase(department.getDepartmantName())){
            deptDB.setDepartmantName(department.getDepartmantName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            deptDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            deptDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepo.save(deptDB);
    }
}