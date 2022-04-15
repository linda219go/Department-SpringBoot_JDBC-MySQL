//package com.dailycode.SB.repository;
//
//import com.dailycode.SB.entity.Department;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
//
//class DepartmentRepositoryTest {
//    @Autowired
//    private DepartmentRepository departmentRepository;
//    @Autowired
//    private TestEntityManager entityManager;
//    @BeforeEach
//    void setUp() {
//        Department department = Department.builder()
//                .dptName("CS").dptCode("101")
//                .dptAddress("la la la").build();
//        entityManager.persist(department);
//    }
//    @Test
//    @Disabled
//    public void whenFindById_thenReturnDepartment(){
//        Department department = departmentRepository.findById(1L).get();
//        assertEquals(department.getDptName(),"Chapel");
//    }
//}