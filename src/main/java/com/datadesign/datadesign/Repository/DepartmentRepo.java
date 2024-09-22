package com.datadesign.datadesign.Repository;

import com.datadesign.datadesign.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
/*
    @Query(value = "select d from DEPARTMENT d where d.DEPARTMENT_NAME =:name",nativeQuery = true)
    public Department findByDepartmantName(@Param("name") String departmentName); */

    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
