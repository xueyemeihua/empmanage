package cn.ly.managesys.service;

import cn.ly.managesys.mapper.DeptMapper;
import cn.ly.managesys.pojo.Dept;
import cn.ly.managesys.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptService {

    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

    public List<Dept> getAllDept() {
        List<Dept> allDept = mapper.getAllDept();
        return allDept;
    }
}
