package com.dailycode.SB.service;

import com.dailycode.SB.entity.Department;
import com.dailycode.SB.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
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
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().dptName("APT")
                .dptAddress("Chapel").dptCode("91111")
                .dptId(123L).build();
        Mockito.when(departmentRepository.findByDptNameIgnoreCase("APT"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Get Data based on valid Department Name")
    @Disabled
    public void whenValidDptName_thenDptShouldFound(){
        String dptName = "APT";
        Department found = departmentService.fetchDepartmentByName(dptName);
        assertEquals(dptName,found.getDptName());
    }
}