package cn.ly.managesys.controller;

import cn.ly.managesys.pojo.Emp;
import cn.ly.managesys.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int empno  = Integer.parseInt(request.getParameter("empno"));
        String job = request.getParameter("job");
        int salary = 0;
        String salary1 = request.getParameter("salary");
        if (salary1!="") {
            salary = Integer.parseInt(salary1);
        }
        int bonus = 0;
        String bonus1 = request.getParameter("bonus");
        if (bonus1!=""){
            bonus = Integer.parseInt(bonus1);
        }
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        //当参数超过3个时,就可以将参数封装在对象中传递
        Emp emp = new Emp(empno,job,salary,bonus,deptno);
        int i = new EmpService().updateEmp(emp);
        if (i == 1) {
            response.sendRedirect("toempmanage");
        }else {
            request.setAttribute("updateError","数据库连接失败");
            request.getRequestDispatcher("/updateEmp.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
