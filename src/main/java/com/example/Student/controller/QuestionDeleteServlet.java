package com.example.Student.controller;

import com.example.Student.dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String questionId;
        QuestionDao dao = new QuestionDao();
        int result = 0;
        PrintWriter out = null;



        //1.������������ȡ����ͷ�����û����
        questionId =request.getParameter("questionId");
        //2.����Dao���û������䵽delete������͵����ݿ������
        result = dao.delete(questionId);

        //3.������Ӧ���󽫴������Զ�����д�뵽��Ӧ�壬���������

        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if(result ==1){
            out.print("<font style='color:red;font-size:50px'>����ɾ���ɹ�</font>");
        }else {
            out.print("<font style='color:red;font-size:50px'>����ɾ��ʧ��</font>");
        }

    }


}
