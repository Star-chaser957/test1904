package com.example.Student.controller;

import com.example.Student.dao.UserDao;
import com.example.Student.entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName, password, sex, email;
        UserDao dao = new UserDao();
        Users user = null;
        int result = 0;
        PrintWriter out = null;


        //1����������󣬶�ȡ����ͷ������Ϣ���õ��û�����Ϣ
//        request.setCharacterEncoding("utf-8");
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");


        //2����UserDao���û�������Ϣ��䵽INSERT�������JDBC�淶���͵����ݿ���
        user = new Users(null, userName, password, sex, email);
        result = dao.add(user);


        //3������Ӧ���󽫴������Զ�������ʽд�뵽��Ӧ��
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if (result == 1) {
            out.print("<font style='color:red;font-size:50px'>�û�ע��ɹ�</font>");
        } else {
            out.print("<font style='color:red;font-size:50px'>�û�ע��ʧ��</font>");
        }


        //Tomcat������������������Ӧ����
        //Tomcat����HTTP��ӦЭ������͵�����������������
        //�����������Ӧͷcontent-typeָ������������Ӧ����������ݱ༭
        //��������༭��Ľ���ڴ���Ŷ��չʾ���û�{����}

    }


}
