package com.dao;

import java.sql.*;


public class MyConnection{      
public static Connection con(){
  Connection conn=null;
   
  try {
      
      Class.forName("com.mysql.jdbc.Driver");
      
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","Kalpesh");
  }catch(Exception ex){
      
  }
      
return (conn);
}

public static void main(String[] args)
{
    Connection con=MyConnection.con();
    System.out.println("Done"+con);
}



}  
