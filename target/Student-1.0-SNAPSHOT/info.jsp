<%--
  Created by IntelliJ IDEA.
  User: air_clean
  Date: 2021/6/23
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
  <%
  String result=(String) request.getAttribute("info");
  %>
  <font style="color: red;font-size: 50px">
    <%=result%>
  </font>
</center>
</body>
</html>
