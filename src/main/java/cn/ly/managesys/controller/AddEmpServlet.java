package cn.ly.managesys.controller;

import cn.ly.managesys.pojo.Emp;
import cn.ly.managesys.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //添加员工,返回员工管理页面
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String ename = request.getParameter("ename");
        String job = request.getParameter("job");
        int salary = 0;
        String salary_ = request.getParameter("salary");
        if (!salary_.equals("")) {
            salary = Integer.parseInt(salary_);
        }
        int bonus = 0;
        String bonus_ = request.getParameter("bonus");
        if (!bonus_.equals("")) {
            bonus = Integer.parseInt(bonus_);
        }
        int deptno = 0;
        String deptno_ = request.getParameter("deptno");
        if (!deptno_.equals("")) {
            deptno = Integer.parseInt(deptno_);
        }
//        System.out.println(salary);
//        当参数过多时,需要创建一个对象封装参数进行传递
        Emp emp = new Emp(ename,job,salary,bonus,deptno);
        EmpService service = new EmpService();
        int result = service.insertEmp(emp);
        if (result == 1) {
            response.sendRedirect("toempmanage");
        } else{
            request.getSession().setAttribute("insertError","新增失败");
            response.sendRedirect("addEmp.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
