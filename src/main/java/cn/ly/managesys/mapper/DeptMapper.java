package cn.ly.managesys.mapper;

import cn.ly.managesys.pojo.Dept;
import cn.ly.managesys.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {

//    根据部门编号查询部门信息
    Dept getDeptByDeptno(@Param("deptno") Integer deptno);

//    获取所有部门信息
    List<Dept> getAllDept();

}
