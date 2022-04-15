package com.dailycode.SB.service;

import com.dailycode.SB.entity.Department;
import com.dailycode.SB.error.DptmtNotFoundException;
import com.dailycode.SB.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department deptmt) {
        return departmentRepository.save(deptmt);
    }

    @Override
    public List<Department> fetchdepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long dptId) throws DptmtNotFoundException {
        //return departmentRepository.findByDptId( dptId);
        Optional<Department> department = departmentRepository.findById(dptId);
        if(!department.isPresent()){
            throw new DptmtNotFoundException("Department not available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long dptmtId) {

        departmentRepository.deleteById(dptmtId);
    }

    @Override
    public Department updateDepartment(Long dptmtId, Department dptmt) {
        Department depDB = departmentRepository.findById(dptmtId).get();
        if(Objects.nonNull(dptmt.getDptName()) && !"".equalsIgnoreCase(dptmt.getDptName())){
            depDB.setDptName(dptmt.getDptName());
        }
        if(Objects.nonNull(dptmt.getDptCode()) && !"".equalsIgnoreCase(dptmt.getDptCode())){
            depDB.setDptCode(dptmt.getDptCode());
        }
        if(Objects.nonNull(dptmt.getDptAddress()) && !"".equalsIgnoreCase(dptmt.getDptAddress())){
            depDB.setDptAddress(dptmt.getDptAddress());
        }
        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String dptName) {
        return departmentRepository.findByDptNameIgnoreCase(dptName);
    }
}
