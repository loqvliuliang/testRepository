package com.example.demo.service.persistence;

import com.example.demo.service.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ll on 2017/7/19.
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
