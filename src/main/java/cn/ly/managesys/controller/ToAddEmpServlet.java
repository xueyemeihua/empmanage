package cn.ly.managesys.controller;

import cn.ly.managesys.pojo.Dept;
import cn.ly.managesys.service.DeptService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ToAddEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询所有部门信息并渲染
        DeptService service = new DeptService();
        List<Dept> depts = service.getAllDept();
        request.setAttribute("depts",depts);
        request.getRequestDispatcher("/addEmp.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
