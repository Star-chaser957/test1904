package com.example.Student.dao;

import com.example.Student.entity.Users;
import com.example.Student.util.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JDBCUtil util = new JDBCUtil();

    //用户注册
    public int add(Users users) {
        String sql = "insert into Users(userName,password,sex,email)" +
                "values(?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1, users.getUserName());
            ps.setString(2, users.getPassword());
            ps.setString(3, users.getSex());
            ps.setString(4, users.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    //查询所有用户信息
    public List findAll() {
        String sql = "select * from Users";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List userList = new ArrayList();


        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Users users = new Users(userId, userName, password, sex, email);
                userList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return userList;
    }

    //根据用户编号删除用户信息
    public int delete(String userId){
        String sql = "delete from Users where userId = ?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setInt(1,Integer.valueOf(userId));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }
    public int login(String userName,String password){
        String sql ="select count(*) from Users where userName = ? and password = ?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        int result =0;
        try {
            ps.setString(1,userName);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while (rs.next()){
                result = rs.getInt("count(*)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(rs);
        }
        return result;
    }

}
