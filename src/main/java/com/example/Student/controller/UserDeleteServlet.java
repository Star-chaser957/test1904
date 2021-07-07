package com.example.Student.controller;

import com.example.Student.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId;
        UserDao dao = new UserDao();
        int result =0;
        PrintWriter out = null;


        //1.调用请求对象读取请求头参数用户编号
        userId =request.getParameter("userId");
        //2.调用Dao将用户编号填充到delete命令并发送到数据库服务器
        result = dao.delete(userId);

        //3.调用响应对象将处理结果以二进制写入到响应体，交给浏览器
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if(result ==1){
            out.print("<font style='color:red;font-size:50px'>用户删除成功</font>");
        }else {
            out.print("<font style='color:red;font-size:50px'>用户删除失败</font>");
        }
    }


}
