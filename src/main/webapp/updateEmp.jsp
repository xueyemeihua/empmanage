<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ly
  Date: 2023/1/8
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工信息修改</title>
</head>
<body>
<div align="center">
    <form action="/updateEmp" method="post">
        员工编号:<input name="empno" value="${emp.empno}" readonly><br>
        姓名:<input name="ename" value="${emp.ename}" readonly><br>
        岗位:<input name="job" value="${emp.job}"><br>
        工资:<input name="salary" value="${emp.salary}"><br>
        奖金:<input name="bonus" value="${emp.bonus}"><br>
        入职日期:<input name="hiredate" value="${emp.hiredate}" readonly><br>
        部门:
        <select name="deptno">
            <c:forEach var="dept" items="${depts}">
                <c:if test="${emp.deptno == dept.deptno}">
                    <option value="${dept.deptno}" selected>${dept.dname}</option>
                </c:if>
                <option value="${dept.deptno}">${dept.dname}</option>
            </c:forEach>
        </select>
        <input type="submit" value="修改">
    </form>
    <p style="color: red">${updateError}</p>
</div>
</body>
</html>
