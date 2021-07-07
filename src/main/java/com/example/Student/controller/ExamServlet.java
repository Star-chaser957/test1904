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

        //1.从当前用户私人储物柜得到系统提供四道题目信息
        questionList = (List)session.getAttribute("key");


        //2.从请求包读取用户对于4道题给出答案
        for(Question question:questionList){
            String answer = question.getAnswer();
            Integer questionId = question.getQuestionId();
            String userAnswer = request.getParameter("answer_"+questionId);
            //3.判分
            if(answer.equals(userAnswer)){
                score += 25;
            }
        }


        //4.将分数写入到request中，作为共享数据
        request.setAttribute("info","本次考试成绩"+score);
        //5.请求转发调用jsp讲用户本次考试分数写入到响应体
        request.getRequestDispatcher("info.jsp").forward(request,response);
    }


}
