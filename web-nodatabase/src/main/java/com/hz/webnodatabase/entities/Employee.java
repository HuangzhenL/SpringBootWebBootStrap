package com.hz.webnodatabase.entities;

import lombok.Data;

import java.util.Date;

//使用lombok @Data注解自动生成getter/setter、equals、hashCode、toString方法
@Data
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;// 1:male 0:female
    private Department department;
    private Date birth;

    //构造函数的参数中不带日期
    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }
    public Employee(){}
}
