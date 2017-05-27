/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import entity.FndPermissionTab;
import entity.FndPermissionTabPK;
import entity.User;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Chamini
 */

public class Wrapper {
        
    public void queue(String user, String pass) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?" , "root", "123456");
        Statement st1 = conn1.createStatement();
        st1.executeUpdate("CREATE USER '" + user + "'@'localhost' IDENTIFIED BY '" + pass + "'" );
        }
  
    public void check1(String user, String s, String i, String d, String u) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?" , "root", "123456");
        Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms?" , "root", "123456");
        Statement stmnt1 = conn1.createStatement();
        Statement stmnt  = conn2.createStatement();
        StringBuilder builder = new StringBuilder();
            String select []= {s,i,u,d};
            for (String select1 : select) {
                builder.append(select1).append(",");
            }
            String query = builder.toString();
            if (query == null || query.length() == 0) {           
                out.println(query);
            }else{query = query.substring(0,query.length()-1);}
            
                out.println();
                out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                out.println(query);
                String regex = "\\s*\\b,null\\b\\s*";
                query = query.replaceAll(regex, "");
               // System.out.println(query);
                
                String[] arr = query.split(","); 
                    int k=0;
                    while ( k< arr.length){
                       String word= arr[k];
                       out.println(word);
                  int in =stmnt1.executeUpdate("GRANT " + word + " ON *.* TO '" + user + "'@'localhost'");
                  PreparedStatement preparedStatement = null;
        
 
        String SQL = "INSERT INTO fnd_permission_tab"+ "(Window, Permissions, User) VALUES"+ "(?,?,?)";
        preparedStatement= conn2.prepareStatement(SQL);
        
        preparedStatement.setString(1,"Activity");
        preparedStatement.setString(2, ""+word);
        preparedStatement.setString(3, ""+user);
        preparedStatement.executeUpdate();
        k++;
        
        }
    }

    public void window(String window) {
       out.println("oooooooooooooooooooooooooooooooooooooooooooo");
       out.println(window);
    }
}

