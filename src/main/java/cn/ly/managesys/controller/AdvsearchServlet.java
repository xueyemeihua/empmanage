package cn.ly.managesys.controller;

import cn.ly.managesys.pojo.Emp;
import cn.ly.managesys.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdvsearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String ename = request.getParameter("ename");
        String salary_ = request.getParameter("salary");
        System.out.println(ename);
        System.out.println(salary_);
        EmpService service = new EmpService();
        List<Emp> emps = null;
        //根据用户传参情况,进行分类查询
        if (ename=="" && salary_=="") {
            //查询所有
            emps = service.getAllEmpAndDept();
        } else {
            if (ename=="") {
                //根据工资查
                int salary = Integer.parseInt(salary_);
                emps = service.getEmpByLessThanSalary(salary);
            } else if (salary_==""){
                //根据姓名查
                emps = service.getEmpByEnameLike(ename);
            } else {
                //双条件查询
                int salary = Integer.parseInt(salary_);
                emps = service.getEmpByEnameLikeAndLessThanSalary(ename,salary);
            }
        }
        request.setAttribute("emps",emps);
        request.getRequestDispatcher("/empmanage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
