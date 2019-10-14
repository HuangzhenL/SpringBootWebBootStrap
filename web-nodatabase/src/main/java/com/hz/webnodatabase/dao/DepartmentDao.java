package com.hz.webnodatabase.dao;

import com.hz.webnodatabase.entities.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Component == @Repository、@Service、@Controller（持久层、业务层、控制层）
 * 将类注入到spring容器中管理
 */
@Repository
public class DepartmentDao {

    //使用集合来存储部门信息
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "D-AA"));
        departments.put(102, new Department(102, "D-BB"));
        departments.put(103, new Department(103, "D-CC"));
        departments.put(104, new Department(104, "D-DD"));
        departments.put(105, new Department(105, "D-EE"));
    }

    //返回部门集合
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    //根据部门id返回部门对象
    public Department getDepartment(Integer id){
        return departments.get(id);
    }


}
