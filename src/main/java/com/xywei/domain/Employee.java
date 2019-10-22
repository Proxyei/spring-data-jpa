package com.xywei.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description TODO
 * @Author future
 * @DateTime 2019/10/22 14:52
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {


    /**
     * @Description
     * @Author future
     * @DateTime 2019/10/22 16:09
     * CREATE TABLE `employee` (
     * `emp_id` int(11) NOT NULL,
     * `emp_name` varchar(255) NOT NULL,
     * `emp_email` varchar(255) DEFAULT NULL,
     * PRIMARY KEY (`emp_id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_email")
    private String empEmail;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    @Override
    public String toString() {
        return "employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                '}';
    }
}
