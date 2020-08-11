<%--
  Created by IntelliJ IDEA.
  User: 石成果
  Date: 2020/8/6
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户界面</title>
</head>
<body>
<h1><%=request.getSession().getAttribute("user")%>,欢迎您</h1>
</body>
</html>
