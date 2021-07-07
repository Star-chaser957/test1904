package com.example.Student.controller;

import com.example.Student.dao.UserDao;
import com.example.Student.entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName, password, sex, email;
        UserDao dao = new UserDao();
        Users user = null;
        int result = 0;
        PrintWriter out = null;


        //1调用请求对象，读取请求头参数信息，得到用户的信息
//        request.setCharacterEncoding("utf-8");
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");


        //2调用UserDao将用户对象信息填充到INSERT命令并借助JDBC规范发送到数据库中
        user = new Users(null, userName, password, sex, email);
        result = dao.add(user);


        //3调用响应对象将处理结果以二进制形式写入到响应体
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if (result == 1) {
            out.print("<font style='color:red;font-size:50px'>用户注册成功</font>");
        } else {
            out.print("<font style='color:red;font-size:50px'>用户注册失败</font>");
        }


        //Tomcat负责销毁请求对象和响应对象
        //Tomcat负责将HTTP响应协议包推送到发起请求的浏览器上
        //浏览器根据响应头content-type指定编译器对响应体二进制内容编辑
        //浏览器将编辑后的结果在窗口哦中展示给用户{结束}

    }


}
