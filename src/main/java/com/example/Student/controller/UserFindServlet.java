package com.example.Student.controller;

import com.example.Student.dao.UserDao;
import com.example.Student.entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        UserDao dao = new UserDao();
        PrintWriter out;
//1����Dao����ѯ�������͵����ݿ�������ϣ��õ������û���ϢLise
        List<Users> userList = dao.findAll();


//2������Ӧ�����û���Ϣ���<table>��ǩ�����Զ�������ʽд�뵽��Ӧ��
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        out.print("<table border='2'align='center'>");
        out.print("<tr>");
        out.print("<td>�û����</td>");
        out.print("<td>�û�����</td>");
        out.print("<td>�û�����</td>");
        out.print("<td>�û��Ա�</td>");
        out.print("<td>�û�����</td>");
        out.print("<td>�û�����</td>");
        out.print("</tr>");
        for (Users users:userList) {
            out.print("<tr>");
            out.print("<td>" + users.getUserId() + "</td>");
            out.print("<td>" + users.getUserName() + "</td>");
            out.print("<td>***********</td>");
            out.print("<td>" + users.getSex() + "</td>");
            out.print("<td>" + users.getEmail() + "</td>");
            out.print("<td><a href='/myWeb/user/delete?userId=" + users.getUserId() + "'>ɾ���û�</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");


    }


}
