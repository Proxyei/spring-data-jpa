package com.xywei.test;

import com.xywei.dao.EmployeeDao;
import com.xywei.domain.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

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
        Employee employee = employeeDao.findOne(2L);
        System.out.println("employee--->" + employee);
    }

    @Test
    public void getCount() {
        System.out.println(employeeDao.count());
    }

    @Test
    public void testSave() {
        Employee employee = new Employee("xxx", null);
        employeeDao.save(employee);
    }

    @Test
    public void testUpdate() {
        Employee employee = new Employee();
        employee.setEmpId(10L);
        employee.setEmpName("前端");
        employeeDao.save(employee);

    }

    @Test
    public void testDel() {
        employeeDao.delete(1l);
    }

    @Test
    public void testFindByEmpName() {
        System.out.println(employeeDao.findEmployeeByEmpName("Java"));
    }

    @Test
    public void testFindByEmpNameAndEmpEmail() {
        System.out.println(employeeDao.findEmployeeByEmpNameAndEmpEmail("Java", "D"));
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testUpdateById() {
        employeeDao.updateEmpployeeByID(4L, "第四个", "xxx@163.com");
    }

    /**
     * @Description 测试使用jpa方法名规范进行查询
     * @Author future
     * @DateTime 2019/10/22 22:33
     **/
    @Test
    public void testDefaultFindByEmployeeName() {
        System.out.println(employeeDao.findByEmpName("PHP"));
    }

    @Test
    public void testFindBySQL() {
        System.out.println(employeeDao.findBySQL("Python"));
    }
}
