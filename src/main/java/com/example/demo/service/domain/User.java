package com.example.demo.service.domain;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ll on 2017/7/20.
 */
@Data
@Entity
@Builder
@TableName("alt_user")
public class User{

    @Id
    @GeneratedValue
    private Long id;
    private Long departmentId;
    private String username;
    private String password;
    private String fullName;

}
