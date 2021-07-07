package com.example.Student.controller;

import com.example.Student.entity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ExamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        List<Question> questionList = null;
        int score = 0;
        int sss= 22;
        int ss��s= 22;

        //1.�ӵ�ǰ�û�˽�˴����õ�ϵͳ�ṩ�ĵ���Ŀ��Ϣ
        questionList = (List)session.getAttribute("key");


        //2.���������ȡ�û�����4���������
        for(Question question:questionList){
            String answer = question.getAnswer();
            Integer questionId = question.getQuestionId();
            String userAnswer = request.getParameter("answer_"+questionId);
            //3.�з�
            if(answer.equals(userAnswer)){
                score += 25;
            }
        }


        //4.������д�뵽request�У���Ϊ��������
        request.setAttribute("info","���ο��Գɼ�"+score);
        //5.����ת������jsp���û����ο��Է���д�뵽��Ӧ��
        request.getRequestDispatcher("info.jsp").forward(request,response);
    }


}
