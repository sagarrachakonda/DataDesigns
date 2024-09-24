package com.datadesign.datadesign.Repository;

import com.datadesign.datadesign.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepoTest {

    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                .departmentName("DSA")
                .departmentAddress("Hyd")
                .departmentCode("June2024")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindByIdthenReturnDepartment(){
         Department department = departmentRepo.findById(1L).get();
         assertEquals(department.getDepartmentName(),"DSA");
    }
}