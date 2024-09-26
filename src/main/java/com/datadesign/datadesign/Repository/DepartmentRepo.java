package com.datadesign.datadesign.Repository;

import com.datadesign.datadesign.entity.Department;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@ConfigurationProperties(prefix = "sql")
@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {


    @Query(value = "SELECT * FROM DEPARTMENT WHERE department_name = :name", nativeQuery = true)
    public Department findByDepartmentName(@Param("name") String departmentName);

    @Query(value = "SELECT * FROM DEPARTMENT WHERE department_name = :name and department_address = :address", nativeQuery = true)
    public Department findByDepartmentNameandAddress(@Param("name") String departmentName, @Param("address") String Address);

    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
