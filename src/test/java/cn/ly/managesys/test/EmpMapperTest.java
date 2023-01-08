package cn.ly.managesys.test;

import cn.ly.managesys.mapper.EmpMapper;
import cn.ly.managesys.pojo.Emp;
import cn.ly.managesys.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

public class EmpMapperTest {

    EmpMapper mapper = SqlSessionUtil.getSqlSession().getMapper(EmpMapper.class);
    @Test
    public void TestGetEmps() {
        List<Emp> allEmp = mapper.getAllEmp();
        allEmp.forEach(emp -> {
            System.out.println(emp);
        });
    }

    @Test
    public void TestGetEmp() {
        Emp emp = mapper.getEmpByEmpno(1);
        System.out.println(emp);
    }

    @Test
    public void TestUpdateEmp() {
        Emp emp = new Emp(1,"11",1200,1000,10);
        int i = mapper.updateEmp(emp);
    }



}
