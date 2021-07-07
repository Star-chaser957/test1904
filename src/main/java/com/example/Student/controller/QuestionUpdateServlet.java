package com.example.Student.controller;

import com.example.Student.dao.QuestionDao;
import com.example.Student.entity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class QuestionUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String  title, optionA, optionB, optionC, optionD, answer,questionId;
        QuestionDao dao  =new QuestionDao();
        Question question =null;
        int result = 0;
//        request.setCharacterEncoding("utf-8");
        title = request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");
        questionId = request.getParameter("questionId");


        question =new Question(Integer.valueOf(questionId),title, optionA, optionB, optionC, optionD, answer);

        result = dao.update(question);
        if(result ==1){
            request.setAttribute("info","试题更新成功");
        }else {
            request.setAttribute("info","试题更新失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }


}
