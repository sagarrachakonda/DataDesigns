package com.datadesign.datadesign.service;

import com.datadesign.datadesign.Repository.DepartmentRepo;
import com.datadesign.datadesign.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepo departmentRepo;

    @BeforeEach
    void setUp() {

        Department department =
                   Department.builder()
                           .departmentName("DSA")
                           .departmentAddress("Hyd")
                           .departmentId(1L)
                           .build();
        Mockito.when(departmentRepo.findByDepartmentNameIgnoreCase("DSA"))
                .thenReturn(department);

        Mockito.when(departmentRepo.findByDepartmentNameIgnoreCase("NDA"))
                .thenReturn(null);
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldfound(){
          String departmentName = "DSA";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }

    @Test
    public void whenInValidDepartmentName_thenDepartmentShouldfound(){
        String departmentName = "NDA";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertNull(found);
    }
}