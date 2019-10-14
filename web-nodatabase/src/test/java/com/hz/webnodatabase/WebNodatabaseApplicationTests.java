package com.hz.webnodatabase;

import com.hz.webnodatabase.dao.EmployeeDao;
import com.hz.webnodatabase.entities.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebNodatabaseApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void EmployeeLoads(){
        Collection<Employee> employees = employeeDao.getAll();
        //增强for遍历员工集合
        for(Employee employee:employees){
            System.out.println(employee);
        }
    }

}
