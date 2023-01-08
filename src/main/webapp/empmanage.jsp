<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理</title>
    <script src="js/jquery-1.12.4.js"></script>
</head>
<body>
<div align="center">
    <form action="/advsearch" method="post">
        姓名:<input name="ename"><br>
        工资:<input name="salary"><br>
        <button>高级搜索</button>
    </form><br>
    <a href="/toAddEmp">添加员工</a><br><br>
    <table border="1px" cellpadding="0px" cellspacing="0px">
        <tr>
            <th>员工编号</th>
            <th>姓名</th>
            <th>岗位</th>
            <th>工资</th>
            <th>领导编号</th>
            <th>奖金</th>
            <th>入职时间</th>
            <th>部门编号</th>
            <th>部门名称</th>
            <th>部门地址</th>
            <th>操作</th>
        </tr>
        <c:forEach var="emp" items="${emps}">
            <tr align="center">
                <td>${emp.empno}</td>
                <td>${emp.ename}</td>
                <td>${emp.job}</td>
                <td>${emp.salary}</td>
                <td>${emp.mgr}</td>
                <td>${emp.bonus}</td>
                <td>${emp.hiredate}</td>
                <td>${emp.deptno}</td>
                <td>${emp.dept.dname}</td>
                <td>${emp.dept.dlocation}</td>
                <td>
                    <a href="/toUpdateEmp?empno=${emp.empno}" methods="post">修改</a>
                    <a href="javascript:void (0)" onclick="deleteEmp(${emp.empno})">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p style="color: red">${advsError}</p>
    <p style="color: red">${deleteError}</p>

</div>

<script>
    function deleteEmp(empno) {
        var b = confirm("真的要删除编号为"+empno+"的员工吗?");
        if (b) {
            window.location="/deleteEmp?empno="+empno;
        }
    }
</script>

</body>
</html>
