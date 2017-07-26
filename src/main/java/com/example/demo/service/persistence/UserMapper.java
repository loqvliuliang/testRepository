package com.example.demo.service.persistence;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.service.domain.Department;
import com.example.demo.service.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by ll on 2017/7/20.
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{

    //根据部门ID查询部门的人
   List<User> findUsers(Long departmentId);



   //获取用户所在的部门
    Department findDepartment(User user);

}
