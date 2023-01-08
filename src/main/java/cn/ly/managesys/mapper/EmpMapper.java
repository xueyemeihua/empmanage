package cn.ly.managesys.mapper;

import cn.ly.managesys.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

//    获取所有员工
    List<Emp> getAllEmp();

//    查询获取所有员工和部门信息
    List<Emp> getAllEmpAndDept();

//    新增员工
    int insertEmp(@Param("emp") Emp emp);

//    查询少于此工资的员工信息和部门信息
    List<Emp> getEmpByLessThanSalary(@Param("salary") int salary);

//    根据姓名模糊查询员工信息和部门信息
    List<Emp> getEmpByEnameLike(@Param("ename") String ename);

//    根据模糊姓名和工资查询员工和部门信息
    List<Emp> getEmpByEnameLikeAndLessThanSalary(@Param("ename") String ename, @Param("salary") int salary);

//    根据编号查员工信息和部门信息
    Emp getEmpByEmpno(@Param("empno") int empno);

//    修改员工信息
    int updateEmp(@Param("emp") Emp emp);
}
