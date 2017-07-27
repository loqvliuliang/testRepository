package com.example.demo.service.service;

import com.example.demo.service.domain.Department;

import java.util.List;

/**
 * Created by ll on 2017/7/19.
 */
public interface DepartmentService {
    List<Department> searchDepartment(String name);

    Department createTest(Department department);

    void insertDept(Department department);
    void updateDeptById(Department department);
    void deleteDeptById(Long id);

    //使用mybatis-plus

//    List<Department> select(Wrapper deptmentWrapper);

}
