package com.dailycode.SB.service;

import com.dailycode.SB.entity.Department;
import com.dailycode.SB.error.DptmtNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
  Department saveDepartment(Department deptmt);

    List<Department> fetchdepartmentList();
  Department fetchDepartmentById(Long dptId) throws DptmtNotFoundException;

  void deleteDepartmentById(Long dptmtId);

  Department updateDepartment(Long dptmtId, Department dptmt);

  Department fetchDepartmentByName(String dptName);
}
