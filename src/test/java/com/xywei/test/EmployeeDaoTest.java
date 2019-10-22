package com.xywei.test;

import com.xywei.dao.EmployeeDao;
import com.xywei.domain.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    /**
     * @Description 分页，证明了分页是一部分一部分查询出来的
     * @Author future
     * @DateTime 2019/10/23 0:43
     **/
    @Test
    public void testPage() {
        System.out.println("1-----------------------------------------------------------------------------------");
        int currentPage = 0;
        int pageSize = 3;
        Pageable pageable = new PageRequest(currentPage, pageSize);
        Page<Employee> page = employeeDao.findAll(pageable);
        System.out.println("第" + (currentPage + 1) + "页数据总数：>>>>>>>>>>>>>>>>>>>" + page.getTotalElements());
        System.out.println("第" + (currentPage + 1) + "页所有数据内容：>>>>>>>>>>>>>>>>>>>" + page.getContent());
        System.out.println("总共页数：>>>>>>>>>>>>>>>>>>>>>>>>>" + page.getTotalPages());

        System.out.println("2-----------------------------------------------------------------------------------");

        currentPage = 1;
        pageSize = 3;
        pageable = new PageRequest(currentPage, pageSize);
        page = employeeDao.findAll(pageable);
        System.out.println("第" + (currentPage + 1) + "页数据总数：>>>>>>>>>>>>>>>>>>>" + page.getTotalElements());
        System.out.println("第" + (currentPage + 1) + "页所有数据内容：>>>>>>>>>>>>>>>>>>>" + page.getContent());
        System.out.println("总共页数：>>>>>>>>>>>>>>>>>>>>>>>>>" + page.getTotalPages());
        pageable = new PageRequest(currentPage, pageSize);

        System.out.println("3-----------------------------------------------------------------------------------");
        pageable = page.nextPageable();
        page = employeeDao.findAll(pageable);
        System.out.println("第" + (pageable.getPageNumber() + 1) + "页数据总数：>>>>>>>>>>>>>>>>>>>" + page.getTotalElements());
        System.out.println("第" + (pageable.getPageNumber() + 1) + "页所有数据内容：>>>>>>>>>>>>>>>>>>>" + page.getContent());
        System.out.println("总共页数：>>>>>>>>>>>>>>>>>>>>>>>>>" + page.getTotalPages());


    }
}
