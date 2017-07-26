package com.example.demo.service.service;

import com.example.demo.service.domain.Department;
import com.example.demo.service.domain.User;
import com.example.demo.service.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ll on 2017/7/20.
 */
@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUsersByDepartmentId(Long id) {
        List<User> list = userMapper.findUsers(id);
        return list;
    }

    @Override
    public Department findDepartmentByUser(User user) {
        Department de =userMapper.findDepartment(user);
        return de;
    }




    public Department createDepartment(Department department){
        return null;
    }

}
