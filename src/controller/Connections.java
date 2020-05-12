/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Memento
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Memento
 */
public class Connections{
    private final String url ="jdbc:postgresql://localhost:5432/MyDb";
    private final String user ="postgres";
    private final String password ="root";
    public Connection con = null;
    protected Statement st = null;
    protected PreparedStatement ps=null;
    protected ResultSet rs= null;
    
    public void connect(){
    try{
    con = DriverManager.getConnection(url, user, password);
    
    }catch(SQLException e){
        e.printStackTrace();
    }
    }
    public void disconnect(){
    
    try{
    if(con != null){
    con.close();
    }
    if(st!=null){
    st.close();
    }
    if(ps!=null){
    ps.close();
    }
    if(rs!=null){
    rs.close();
    }
    
    
    }catch(SQLException e){
    e.printStackTrace();
    }
    }
}
