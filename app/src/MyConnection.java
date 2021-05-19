/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author PR3YDATOR
 */
class MyConnection {
    

 public static Connection connection() throws SQLException
 {
     try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hrsh", "123456");
           
  //      conn.setAutoCommit(true);
        return conn;
     }
     catch(ClassNotFoundException | SQLException e)
     {
         JOptionPane.showMessageDialog(null,e);
         return null;
          
     }


}
}


