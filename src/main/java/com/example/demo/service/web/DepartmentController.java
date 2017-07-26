package com.example.demo.service.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.service.domain.Department;
import com.example.demo.service.persistence.DepartmentRepository;
import com.example.demo.service.service.DepartmentService;

import com.example.demo.service.service.DepartmentServiceImpl;
import com.example.demo.service.util.StringUtil;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by ll on 2017/7/19.
 */

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    private final DepartmentService departmentService;

    private final DepartmentServiceImpl deptServiceImpl;

    public DepartmentController(DepartmentRepository departmentRepository, DepartmentService departmentService, DepartmentServiceImpl deptServiceImpl) {
        this.departmentRepository = departmentRepository;
        this.departmentService = departmentService;
        this.deptServiceImpl = deptServiceImpl;
    }

    //分页查询部门列表
    @GetMapping("/departments")
    public List<Department> getDepartments(@RequestParam int page, @RequestParam int pageSize){
        List<Department> list = deptServiceImpl.searchDepartment(page,pageSize);
        for(Department de:list){
            String str = StringUtil.formatZonedTime(de.getCreateDate());
            System.out.println(str);
        }
        return list;
    }


    //根据ID查询部门
    @GetMapping("/departments/{departmentId}")
    public Department getDepartmentByID(@PathVariable Long departmentId){
        System.out.print(departmentId);
        Department department =  deptServiceImpl.selectById(departmentId);

        return department;
    }


    //根据部门名称查询部门列表??没找到xml
    @GetMapping("/departments/search/{name}")
    public  List<Department> searchDepartment(@PathVariable String name){
        List<Department> list = departmentService.searchDepartment(name);
        return list;
    }

    //插入部门
    @PostMapping("/api/departments/createDepartment")
    public boolean createDepartment(@RequestBody Department department){
        boolean falg = deptServiceImpl.insert(department);
        return falg;
    }

    //更新部门
    @PutMapping("/departments/updateDepartment")
    public boolean updateDepartment(@RequestBody Department department){
        boolean flag = deptServiceImpl.updateById(department);
        return flag;
    }

    //删除部门
    @DeleteMapping("/departments/{departmentId}")
    public boolean deleteDepartmentById(@PathVariable Long departmentId){
        boolean flag = deptServiceImpl.deleteById(departmentId);
        return flag;
    }



    @GetMapping("/test/updateNotNull")
    public boolean test1(){
        Department department =new Department();
        department.setName("aaaaa");
        boolean flag = deptServiceImpl.update(
                department,
                new EntityWrapper<Department>().eq("name","123")
        );
        return flag;
    }


    @GetMapping("/test/updateAll")
    public boolean test2(){
        Department department =new Department();
        department.setId(130L);
        department.setName("000");
        department.setCode("000");
        department.setCreateDate(ZonedDateTime.now());
        department.setStatus(1);
        boolean flag = deptServiceImpl.updateAllColumnById(department);
        return flag;
    }











    //查询
    @GetMapping("/mybatis/queryall")
    public List<Department> query(){
        List<Department> list =  departmentRepository.findAll();
        return list;
    }


    //删除
    @DeleteMapping("/mybatis/delete")
    public void delete (@RequestBody Department department) {
        departmentRepository.delete(department);
    }


    //删除
    @DeleteMapping("/mybatis/deleteById/{dept_id}")
    public void delete (@PathVariable Long dept_id) {
        departmentRepository.delete(dept_id);
    }

    //更新
    @PutMapping("/mybatis/updateById")
    public void update(@RequestBody Department department){
        departmentService.updateDeptById(department);
    }

    //创建
    @PostMapping("/mybatis/create")
    public void create(@RequestBody Department department){
//       Department dept = deptRepository.save(department);
        departmentService.insertDept(department);
    }

    @PostMapping("/insertDept")
    public void insert(@RequestBody Department department){
        departmentService.insertDept(department);
    }

    //使用mybatis-plus
    //插入数据
    @PostMapping("/mapperPlus/insert")
    public boolean insertDepartment(@RequestBody Department department){

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        department.setCreateDate(zonedDateTime);
        System.out.print(department.toString());
        boolean flag = deptServiceImpl.insert(department);
        return flag;
    }
}
