package cn.ly.managesys.controller;

import cn.ly.managesys.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empno = Integer.parseInt(request.getParameter("empno"));
//        System.out.println(empno);
        int i = new EmpService().deleteEmpByEmpno(empno);
        if (i==1){
            //刷新页面
            response.sendRedirect("toempmanage");
        } else {
            //提示
            request.setAttribute("deleteError","数据库删除失败");
            request.getRequestDispatcher("/empmanage").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
