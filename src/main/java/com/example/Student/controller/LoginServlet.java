package com.example.Student.controller;

import com.example.Student.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName, password;

        UserDao dao = new UserDao();

        int result  = 0;
        //1.������������������ʹ��utf-8�ַ����������±༭
        request.setCharacterEncoding("utf-8");


        //2.������������ȡ�����������Ϣ
        userName = request.getParameter("userName");
        password = request.getParameter("password");


        //3.����Dao����ѯ��֤��Ϣ���͵����ݿ��������
        result = dao.login(userName,password);

        //4.������Ӧ���󣬸�����֤�������ͬ��Դ�ļ���ַд�뵽��Ӧͷ�����������
        if(result==1){
            response.sendRedirect("/myWeb/index.html");
        }else {
            response.sendRedirect("/myWeb/login_error.html");
        }
    }
}
