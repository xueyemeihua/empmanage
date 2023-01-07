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
}
