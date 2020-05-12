/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Courses;

/**
 *
 * @author Memento
 */
public class CourseController extends Connections {
    public CourseController(){
        connect();
        try{
            st = con.createStatement();
            final String q = "create table if not exists Courses"
                    +"("
                    +"Code varchar(30) primary key,"
                    +"Course_Name varchar(30),"
                    +"Credits varchar(30)"
                    +");";
            st.execute(q);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            disconnect();
        }
    }
        public void enterCourses(Courses c){
            connect();
            try{
              ps = con.prepareStatement("insert into courses values(?,?,?)");
              ps.setString(1, c.getCourseCode());
              ps.setString(2,c.getCourseName());
              ps.setString(3, c.getNumberOfCredits());
              ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                disconnect();
            }
        }
        public ResultSet showAllCourses(){
       connect();
       try{
           final String f = "select * from courses";
           st = con.createStatement();
           rs=st.executeQuery(f);
       }catch(SQLException e){
           e.printStackTrace();
       }
       
        return rs;
        }
        public void deleteCourse(Courses c){
            connect();
            try{
                ps = con.prepareStatement("delete from courses where code=?");
                ps.setString(1, c.getCourseCode());
                ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                disconnect();
            }
                
        }
        public void update_course(Courses c){
            connect();
            try{
                String sql = "update courses set course_name=?,credits=? where code=?";
                ps=con.prepareStatement(sql);
                ps.setString(1,c.getCourseName());
                ps.setString(2,c.getNumberOfCredits());
                ps.setString(3, c.getCourseCode());
                ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    

