package com.example.Student.dao;

import com.example.Student.entity.Question;
import com.example.Student.util.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    JDBCUtil util = new JDBCUtil();

    public int add(Question question) {
        String sql = "insert into question(title, optionA, optionB, optionC, optionD, answer)values(?,?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1, question.getTitle());
            ps.setString(2, question.getOptionA());
            ps.setString(3, question.getOptionB());
            ps.setString(4, question.getOptionC());
            ps.setString(5, question.getOptionD());
            ps.setString(6, question.getAnswer());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }


    public List findAll() {
        String sql = " select * from question";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List questionList = new ArrayList();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                Question question = new Question(questionId, title, optionA, optionB, optionC, optionD, answer);
                questionList.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return questionList;
    }

    public int delete(String questionId){
        String sql ="delete from question where questionId =?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;

        try {
            ps.setInt(1,Integer.valueOf(questionId));
            result =ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;

    }

    public Question findById(String questionId){
        String sql ="select * from question where questionId =?";
        PreparedStatement ps =util.createStatement(sql);
        ResultSet rs = null;
        Question question = null;
        try {
            ps.setInt(1,Integer.valueOf(questionId));
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer question_Id = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
               question = new Question(question_Id, title, optionA, optionB, optionC, optionD, answer);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return question;
        }



    public  int update(Question question){
        String sql = "update question set title=?, optionA=?, optionB=?, optionC=?, optionD=?, answer=? where questionId =?";

        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1, question.getTitle());
            ps.setString(2, question.getOptionA());
            ps.setString(3, question.getOptionB());
            ps.setString(4, question.getOptionC());
            ps.setString(5, question.getOptionD());
            ps.setString(6, question.getAnswer());
            ps.setInt(7, question.getQuestionId());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    public List findRand(){
        String sql = "select * from question order by rand() limit 0,4";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List questionList = new ArrayList();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                Question question = new Question(questionId, title, optionA, optionB, optionC, optionD, answer);
                questionList.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return questionList;
    }

}
