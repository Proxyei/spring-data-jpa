package com.xywei.dao;

import com.xywei.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Description TODO
 * @Author future
 * @DateTime 2019/10/22 14:53
 * @see org.springframework.data.jpa.repository.JpaRepository  封装CRUD
 * @see org.springframework.data.jpa.repository.JpaSpecificationExecutor  封装分页
 */
public interface EmployeeDao extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

    @Query("from Employee where empName = ?1")
    Employee findEmployeeByEmpName(String empName);

    @Query(value = "from Employee where empName=?1 and empEmail=?2")
    Employee findEmployeeByEmpNameAndEmpEmail(String empName, String empEmail);

    @Modifying
    @Query(value = "update Employee  set empName=:empName, empEmail=:empEmail where empId=:id")
    void updateEmpployeeByID(@Param("id") Long id, @Param("empName") String empName, @Param("empEmail") String empEmail);

    Employee findByEmpName(String empName);

    @Query(value = "select * from employee where emp_name=?1", nativeQuery = true)
    Employee findBySQL(String empName);
}
