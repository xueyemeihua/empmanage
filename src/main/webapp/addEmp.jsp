<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
<div align="center">
    <%--这里的修改信息需要将请求中传回的员工编号从数据库查出信息并回显,将不能修改的信息设置只读属性--%>
    <form action="/addEmp">
        <table>
            <tr>
                <td style="text-align: right">姓名:</td>
                <td><input name="ename"></td>
            </tr>
            <tr>
                <td style="text-align: right">岗位:</td>
                <td><input name="job"></td>
            </tr>
            <tr>
                <td style="text-align: right">工资:</td>
                <td><input name="salary"></td>
            </tr>
            <tr>
                <td style="text-align: right">奖金:</td>
                <td><input name="bonus"></td>
            </tr>
            <tr>
                <td style="text-align: right">部门编号:</td>
                <td>
                    <select name="deptno">
                        <option value="0">请选择</option>
                        <%--这里的下拉框选项应该从数据库中查询出所有部门,并且动态生成下拉框--%>
                        <c:forEach var="dept" items="${depts}">
                            <option value="${dept.deptno}">${dept.dname}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input type="submit" value="添加">
                </td>
            </tr>
        </table>
    </form>
    <p style="color: red">${insertError}</p>
</div>
</body>
</html>
