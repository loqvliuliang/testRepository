package com.example.demo.service.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.service.domain.Department;
import com.example.demo.service.exception.VacationException;
import com.example.demo.service.persistence.DepartmentMapper;
import com.example.demo.service.persistence.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by ll on 2017/7/19.
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper,Department> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    private final DepartmentMapper departmentMapper1;

    private   DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentMapper departmentMapper1) {
            this.departmentMapper1 = departmentMapper1;
    }


    @Override
    public List<Department> searchDepartment(String name) {
        String mappername = "%"+name+"%";
        List<Department> list  = departmentMapper.searchDepartment(mappername);
        return list;
    }





    @Override
    public Department createTest(Department department) {
        department.setName(department.getName()+"111");
        try{
            return this.departmentRepository.save(department);
        }catch (DuplicateKeyException e){
            throw new VacationException(e.getMessage());
        }
    }

    @Override
    public void insertDept(Department department) {
        departmentMapper.insertDept(department);
    }

    public Department insertDept1(Department department) {
     departmentMapper1.insert(department);
      return department;
    }

    @Override
    public void updateDeptById(Department department) {

        departmentMapper.updateDeptById(department);
    }

    @Override
    public void deleteDeptById(Long id) {
        departmentMapper.deleteDeptById(id);
    }

    public List<Department> searchDepartment(int page, int pagesize){
        List<Department> list = departmentMapper.selectPage(new Page<Department>(page,pagesize),new EntityWrapper<>());
        return list;
    }




}
