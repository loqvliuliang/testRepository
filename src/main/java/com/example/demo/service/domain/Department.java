package com.example.demo.service.domain;

import com.baomidou.mybatisplus.annotations.TableName;
import com.example.demo.service.security.AuthenticationMethod;
import lombok.Builder;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * Created by ll on 2017/7/19.
 */
@Data
@Entity
//@Builder
@TableName("alt_department")
public class Department {
        @Id
        @GeneratedValue
        private Long id;
        private String name;
        private String code;
        private int status;
        private ZonedDateTime createDate;
        private AuthenticationMethod authenticationMethod;
}
