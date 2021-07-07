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


        //1.调用Dao对象随机从question表拿出4道题目
        questionList = dao.findRand();

        //2.将4道题添加到request作为共享数据
//        request.setAttribute("key",questionList);
        session.setAttribute("key",questionList);



        //3.请求转发，申请调用exam.jsp将4道题写入到响应体中
        request.getRequestDispatcher("/exam.jsp").forward(request,response);
    }


}
