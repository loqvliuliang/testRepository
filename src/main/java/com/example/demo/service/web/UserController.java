package com.example.demo.service.web;

import com.example.demo.service.domain.Department;
import com.example.demo.service.domain.User;
import com.example.demo.service.service.UserService;
import com.example.demo.service.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ll on 2017/7/20.
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    //根据部门ID查询对应部门下的用户
    @GetMapping("/api/users/search/by/department/{departmentId}")
    public List<User> getByDepartmentId(@PathVariable Long departmentId){
        List<User> list = userService.findUsersByDepartmentId(departmentId);

        return list;
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/getUsersByDepartmentId/{id}")
    public List<User> findByDepartId(@PathVariable Long id){
      List<User> list =  userService.findUsersByDepartmentId(id);
        return list;
    }

    @PostMapping("/findDepartmentByUser")
    public Department findDepartmentByUser(@RequestBody User user){
        System.out.print(user.toString());
        Department department = userService.findDepartmentByUser(user);
        System.out.print(department);
        return department;
    }


    @GetMapping("/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public String greeting() {
        return "Hello " + SecurityUtils.getCurrentUser();
    }


    @GetMapping("/api/public/api")
    public String publicAPI() {
        return "this is public API";
    }
}
