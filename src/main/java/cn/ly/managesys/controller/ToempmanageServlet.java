package cn.ly.managesys.controller;

import cn.ly.managesys.pojo.Emp;
import cn.ly.managesys.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ToempmanageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //跳转到员工管理页,初始页面从数据库查出所有员工并渲染
        EmpService service = new EmpService();
        List<Emp> emps = service.getAllEmpAndDept();
        request.setAttribute("emps",emps);
        request.getRequestDispatcher("/empmanage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
