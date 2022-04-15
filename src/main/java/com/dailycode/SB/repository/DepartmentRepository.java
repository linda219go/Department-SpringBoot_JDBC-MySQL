package com.dailycode.SB.repository;

import com.dailycode.SB.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {


//    @Query("select d from Department d where d.dptName = ?1")
//    Department findByDptName(String dptName);

    @Query("select d from Department d where upper(d.dptName) = upper(?1)")
    Department findByDptNameIgnoreCase(String dptName);
}
