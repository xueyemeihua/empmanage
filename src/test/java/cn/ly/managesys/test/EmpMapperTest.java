package cn.ly.managesys.test;

import cn.ly.managesys.mapper.EmpMapper;
import cn.ly.managesys.pojo.Emp;
import cn.ly.managesys.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class EmpMapperTest {

    EmpMapper mapper = SqlSessionUtil.getSqlSession().getMapper(EmpMapper.class);
    @Test
    public void TestGetAllEmp() {
        List<Emp> allEmp = mapper.getAllEmp();
        allEmp.forEach(emp -> {
            System.out.println(emp);
        });
    }

    @Test
    public void TestGetAllEmpAndDept() {
        List<Emp> allEmp = mapper.getAllEmpAndDept();
        allEmp.forEach(emp -> {
            System.out.println(emp);
        });
    }


}
