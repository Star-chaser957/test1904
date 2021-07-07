package com.example.Student.controller;

import com.example.Student.dao.QuestionDao;
import com.example.Student.entity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class QuestionFindByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String questionId;

        QuestionDao dao = new QuestionDao();
        Question question = null;
        //1.������������ȡ����ͷ�в�����Ϣ���õ�������
        questionId = request.getParameter("questionId");
        //2.����Dao���Ͳ�ѯ����õ���������Ŷ�Ӧ��������Ϣ
         question = dao.findById(questionId);
        //3.����question_update.jsp��������Ϣд�뵽��Ӧ��
        request.setAttribute("key",question);
        request.getRequestDispatcher("/question_update.jsp").forward(request,response);
    }


}
