package cn.ly.managesys.controller;

import cn.ly.managesys.pojo.Dept;
import cn.ly.managesys.pojo.Emp;
import cn.ly.managesys.service.DeptService;
import cn.ly.managesys.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ToUpdateEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将用户发送的请求参数获取,该请求应该带上要修改员工的编号
        //因为员工编号一定存在,所有直接转型
        int empno = Integer.parseInt(request.getParameter("empno"));
        //调用查询方法,将员工信息查到
        Emp emp = new EmpService().getEmpByEmpno(empno);
        //查询部门信息
        List<Dept> depts = new DeptService().getAllDept();
        //存到域对象让其回显
        request.setAttribute("emp",emp);
        request.setAttribute("depts",depts);
        //跳转到修改页面
        request.getRequestDispatcher("/updateEmp.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
