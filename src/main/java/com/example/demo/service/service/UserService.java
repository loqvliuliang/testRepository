package com.example.demo.service.service;

import com.example.demo.service.domain.Department;
import com.example.demo.service.domain.User;

import java.util.List;

/**
 * Created by ll on 2017/7/20.
 */
public interface UserService {
    List<User> findUsersByDepartmentId(Long id);
    Department findDepartmentByUser(User user);

}
