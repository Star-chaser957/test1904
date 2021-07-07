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

//1.调用DAO推送查询命令得到所有试题
        List questionlist=dao.findAll();
//2.将得到的试题添加到请求作用域作为共享数据
        request.setAttribute("key",questionlist);
//3.请求转发向tomcat调用question.jsp将结果与html标签写入响应体
        request.getRequestDispatcher("/question.jsp").forward(request,response);
    }


}
