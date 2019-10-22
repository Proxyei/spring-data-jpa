package com.xywei.dao;

import com.xywei.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description TODO
 * @see org.springframework.data.jpa.repository.JpaRepository  封装CRUD
 * @see org.springframework.data.jpa.repository.JpaSpecificationExecutor  封装分页
 * @Author future
 * @DateTime 2019/10/22 14:53
 */
public interface EmployeeDao extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
}
