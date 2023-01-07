package cn.ly.managesys.service;

import cn.ly.managesys.mapper.EmpMapper;
import cn.ly.managesys.pojo.Emp;
import cn.ly.managesys.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpService {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);


    public List<Emp> getAllEmpAndDept() {
        List<Emp> emps = mapper.getAllEmpAndDept();
        return emps;
    }

    public int insertEmp(Emp emp) {
        int i = mapper.insertEmp(emp);
        return i;
    }

    public List<Emp> getEmpByLessThanSalary(int salary) {
        List<Emp> emps = mapper.getEmpByLessThanSalary(salary);
        return emps;
    }

    public List<Emp> getEmpByEnameLike(String ename) {
        List<Emp> emps = mapper.getEmpByEnameLike(ename);
        return emps;
    }

    public List<Emp> getEmpByEnameLikeAndLessThanSalary(String ename, int salary) {
        List<Emp> emps = mapper.getEmpByEnameLikeAndLessThanSalary(ename,salary);
        return emps;
    }
}
