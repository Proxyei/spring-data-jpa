package com.xywei.test;

import com.xywei.dao.EmployeeDao;
import com.xywei.domain.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description TODO
 * @Author future
 * @DateTime 2019/10/22 16:15
 */
public class EmployeeDaoTest extends SpringTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testFindById() {
        Employee employee = employeeDao.findOne(3L);
        System.out.println("employee--->" + employee);
    }

    @Test
    public void getCount() {
        System.out.println(employeeDao.count());
    }
}
