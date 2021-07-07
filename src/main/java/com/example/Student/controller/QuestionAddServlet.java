package com.example.Student.controller;

import com.example.Student.dao.QuestionDao;
import com.example.Student.entity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String title, optionA, optionB, optionC, optionD, answer;
        QuestionDao dao  =new QuestionDao();
        Question question =null;
        int result = 0;



        //1.������������ȡ������Ϣ���õ�������Ϣ����
//        request.setCharacterEncoding("utf-8");
        title = request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");

        //2.����Dao����Insert�������͵����ݿ⣬���õ�������
        question =new Question(null,title, optionA, optionB, optionC, optionD, answer);
        result = dao.add(question);
        //3.ͨ��Tomcat��Ҫinfo.jsp��������д�뵽��Ӧ��
        if(result ==1){
            request.setAttribute("info","������ӳɹ�");
        }else {
            request.setAttribute("info","�������ʧ��");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);

    }


}
