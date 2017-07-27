package com.example.demo.service.persistence;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.service.domain.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by ll on 2017/7/19.
 */

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
    void  insertDept(Department department);

    void updateDeptById(Department department);

    void deleteDeptById(Long id);

    List<Department> searchDepartment(String name);

    List<Department> searcdAllDepartment();

    Department getDepartment();

}
