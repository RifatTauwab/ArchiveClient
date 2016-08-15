/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Tauwab Uz Zahir
 */
package archive_v1;
import java.sql.*;
import javax.swing.*;
public class ConnectDB_test {
    Connection conn = null;
    public static Connection connectDb(){
        
      
        try{
       Class.forName("com.mysql.jdbc.Driver");  
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/archive","root","password");  
      //JOptionPane.showMessageDialog(null, "connected");
       System.out.print("Connected\n");
       return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }
        
    }
    
}
