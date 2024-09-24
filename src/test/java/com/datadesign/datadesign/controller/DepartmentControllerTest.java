package com.datadesign.datadesign.controller;

import com.datadesign.datadesign.ExceptionHandling.DepartmentNotFoundException;
import com.datadesign.datadesign.entity.Department;
import com.datadesign.datadesign.service.DepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void setUp() {

        department =
                Department.builder()
                        .departmentId(1L)
                        .departmentName("DSA")
                        .departmentAddress("Hyd")
                        .departmentCode("July2024")
                        .build();

    }

    @Test
    void saveDepartment() throws Exception {
        Department inputdepartment =
                Department.builder()
                        .departmentName("DSA")
                        .departmentAddress("Hyd")
                        .departmentCode("July2024")
                        .build();

        Mockito.when(departmentService.saveDepartment(inputdepartment))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\": \"DSA\",\n" +
                        "    \"departmentAddress\": \"Hyd\",\n" +
                        "    \"departmentCode\": \"July2024\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }

    @Test
    void deleteDepartmentById() throws Exception {
        Long departmentId = 1L;

        // Mock the service to ensure it doesn't throw any exception
        Mockito.doNothing().when(departmentService).deleteDepartmentById(departmentId);

        // Perform the DELETE request and validate the response
        mockMvc.perform(MockMvcRequestBuilders.delete("/departments/{id}", departmentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())  // Expect 200 OK status
                .andExpect(content().string("Deleted Department Successfully"));  // Verify response message
    }
    @Test
    void updateDepartment() throws Exception {
        Long departmentId = 1L;

        Department department = Department.builder()
                .departmentName("Updated Department")
                .departmentAddress("New Address")
                .departmentId(departmentId)
                .build();

        // Mock the service method to return the updated department
        Mockito.when(departmentService.updateDepartment(Mockito.eq(departmentId), Mockito.any(Department.class)))
                .thenReturn(department);

        // Convert the department object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String departmentJson = objectMapper.writeValueAsString(department);

        // Perform the PUT request and validate the response
        mockMvc.perform(MockMvcRequestBuilders.put("/departments/{id}", departmentId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(departmentJson))  // Send the department as JSON
                .andExpect(status().isOk())  // Expect 200 OK status
                .andExpect(jsonPath("$.departmentName").value("Updated Department"))
                .andExpect(jsonPath("$.departmentAddress").value("New Address"))
                .andExpect(jsonPath("$.departmentId").value(departmentId));
    }
}