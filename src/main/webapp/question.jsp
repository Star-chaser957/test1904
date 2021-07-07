<%@ page import="java.util.List" %>
<%@ page import="com.example.Student.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: air_clean
  Date: 2021/6/23
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2" align="center">
    <tr align="center">
        <td>题目编号</td>
        <td>题目信息</td>
        <td>A选项</td>
        <td>B选项</td>
        <td>C选项</td>
        <td>D选项</td>
        <td>正确答案</td>
        <td colspan="2">操作</td>
    </tr>
    <%
        List questionList=(List) request.getAttribute("key");
        for (int i = 0;i<questionList.size();i++){
            Question question = (Question) questionList.get(i);

    %>
    <tr>
        <td><%=question.getQuestionId()%></td>
        <td><%=question.getTitle()%></td>
        <td><%=question.getOptionA()%></td>
        <td><%=question.getOptionB()%></td>
        <td><%=question.getOptionC()%></td>
        <td><%=question.getOptionD()%></td>
        <td><%=question.getAnswer()%></td>
        <td>
            <a href="/myWeb/question/delete?questionId=<%=question.getQuestionId()%>">删除试题</a>
        </td>
        <td>
            <a href="/myWeb/question/findById?questionId=<%=question.getQuestionId()%>">详细信息</a>
        </td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
