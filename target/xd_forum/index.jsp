<%--
  Created by IntelliJ IDEA.
  User: 85304
  Date: 2020/9/16
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>论坛</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/jquery.min.js"></script>
</head>
<body>

<div class="container">
    <ul class="nav nav-tabs">
        <c:forEach items="${categoryList}" var="category">
            <li>
                <a href="${pageContext.request.contextPath}/topic?method=list&c_id=${category.id}">${category.name}</a>
            </li>
            
            <c:choose>
                <c:when test="${empty loginUser}">
                    <li style="float: right"><a href="${pageContext.request.contextPath}/user/register.jsp">注册</a></li>
                    <li style="float: right"><a href="${pageContext.request.contextPath}/user/login.jsp">登录</a></li>
                </c:when>
                <c:otherwise>
                    <li style="float: right"><a href="${pageContext.request.contextPath}/user?method=logout">注销</a></li>
                    <li style="float: right"><a href="#">${loginUser.username}</a></li>
                    <li style="float: right"><img src="${loginUser.img}" class="img-circle" width="25px" height="25px" style="margin-top: 8.5px"></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </ul>
</div>


</body>
</html>
