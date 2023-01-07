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
}
