package com.hz.webnodatabase.dao;

import com.hz.webnodatabase.entities.Department;
import com.hz.webnodatabase.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    //使用集合来存储员工信息
    private static Map<Integer, Employee> employees = null;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
        employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
        employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
        employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
        employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));

    }

    private static Integer initId = 1006; //添加员工时，id自增

    //@Autowired后，不需要getter()、setter()方法，spring会自动注入
    @Autowired
    private DepartmentDao departmentDao;

    //添加员工信息
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //根据id返回员工对象
    public Employee get(Integer id){
        return employees.get(id);
    }
    //删除指定员工
    public void delete(Integer id){
        employees.remove(id);
    }

}
