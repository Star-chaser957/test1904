package com.example.Student.controller;

import com.example.Student.dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QuestionDao dao= new QuestionDao();

//1.����DAO���Ͳ�ѯ����õ���������
        List questionlist=dao.findAll();
//2.���õ���������ӵ�������������Ϊ��������
        request.setAttribute("key",questionlist);
//3.����ת����tomcat����question.jsp�������html��ǩд����Ӧ��
        request.getRequestDispatcher("/question.jsp").forward(request,response);
    }


}
