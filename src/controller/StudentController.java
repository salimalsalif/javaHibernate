/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author Memento
 */
public class StudentController extends Connections{
    public StudentController(){
        connect();
        try{
            st = con.createStatement();
            String sql ="create table if not exists Student2"
                    +"("
                    +"First_Name varchar(30),"
                    +"Last_Name varchar(30),"
                    +"Id varchar(30) primary key,"
                    +"Grades varchar(30),"
                    +"Date_of_Birth varchar(50),"
                    +"Gender varchar(30),"
                    +"Courses varchar(30),"
                    +"Photo varchar(90)"
                    +");";
            st.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            disconnect();
        }
    }
    public void SaveData(Student std){
        connect();
        try{
    
            ps=con.prepareStatement("insert into Student2 values(?,?,?,?,?,?,?,?)");
            ps.setString(1, std.getFirstName());
            ps.setString(2,std.getLastName());
            ps.setString(3, std.getId());
            ps.setString(4, std.getGrades());
            ps.setString(5, std.getDob());
            ps.setString(6, std.getGender());
            ps.setString(7, std.getCourse());
            ps.setString(8,std.getPicture());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            disconnect();
        }
    }
    public ResultSet ListStudent(){
        connect();
        try{
            st = con.createStatement();
            final String sql ="Select * from Student2";
            rs=st.executeQuery(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
   /* public ResultSet searchStudent(Student std){
        connect();
        try{
            ps = con.prepareStatement("select * from Student1 where id =?");
           ps.setString(1, std.getId());
           rs=ps.executeQuery();
           if(rs.next()){
               Student s = new Student();
               
               s.setFirstName(rs.getString("first_name"));
               s.setLastName(rs.getString("last_name"));
               s.setId(rs.getString("id"));
               s.setGrades(rs.getString("grades"));
               s.setDob(rs.getString("date_of_birth"));
               s.setGender(rs.getString("gender"));
               s.setCourse(rs.getString("courses"));
           }
                    } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }*/
}
