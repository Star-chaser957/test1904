package com.example.Student.controller;

import com.example.Student.dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class QuestionRandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        QuestionDao dao  = new QuestionDao();
        List questionList = null;
        HttpSession session =request.getSession(false);


        //1.����Dao���������question���ó�4����Ŀ
        questionList = dao.findRand();

        //2.��4������ӵ�request��Ϊ��������
//        request.setAttribute("key",questionList);
        session.setAttribute("key",questionList);



        //3.����ת�����������exam.jsp��4����д�뵽��Ӧ����
        request.getRequestDispatcher("/exam.jsp").forward(request,response);
    }


}
