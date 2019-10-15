package com.hz.webnodatabase.controller;

import com.hz.webnodatabase.dao.DepartmentDao;
import com.hz.webnodatabase.dao.EmployeeDao;
import com.hz.webnodatabase.entities.Department;
import com.hz.webnodatabase.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        //获取员工信息
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        //thymeleaf 默认拼串(classpath:/templates/XXX.html)
        return "emp/list"; //classpath:/templates/emp/list.html
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面，查出所有的部门，在添加页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        //放在请求域中
        model.addAttribute("depts",departments);
        //classpath:/templates/emp/list.html
        return "emp/add";
    }

    //员工添加
    //SpringMVC 自动将请求参数和入参对象的属性一一绑定，
    // 要求请求参数的名字和javaBean入参的对象例的属性名相同，即页面中的name属性名与实体类中的属性名一致
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        //重定向回到员工列表页面 / 表示当前项目路径
        return "redirect:/emps";
    }

    //来到员工修改页面，并查出当前员工信息，在页面回显
    //修改页面与添加页面二合一，通过判断emp是否为空来显示修改或添加
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        //回到修改页面
        return "emp/add";
    }

    //员工修改:提交员工id
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
