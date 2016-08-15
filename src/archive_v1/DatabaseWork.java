/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_v1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author DeeptoTV
 */
public class DatabaseWork {
    Connection conn_archive = null;
    CallableStatement stored_pro = null;
    Statement statement_archive = null;
    ResultSet rs_archive = null;
    PreparedStatement pst; 
    public void create_archive_connection()
    {
        conn_archive = ConnectDB_test.connectDb();
    }
    public Boolean login_check(String username,String password)
    {
        String sql = "";
        int total = 0;
        create_archive_connection();
        try{
            statement_archive = conn_archive.createStatement();
            sql = "select count(user_id) as total from registration where user_id <='"+username+"' and password = '"+password+"'";
            rs_archive = statement_archive.executeQuery(sql);
            while(rs_archive.next())
            {
                total = rs_archive.getInt("total");
            }
            System.out.println(sql);
            System.out.println(total);
        }catch(Exception e)
        {
            System.out.println(e);
        }finally{
            try{
            conn_archive.close();
            }catch(Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }
        if(total == 0)
            return false;
        else 
            return true;
    }
    
    public ResultSet retrieve(String name)
    {
        String sql = "";
        ResultSet rs_return = null;
        create_archive_connection();
        try
        {
            statement_archive = conn_archive.createStatement();
            sql = "select * from archive where  program_name COLLATE UTF8_GENERAL_CI like '%"+name+"%' order by program_name";
            System.out.println(sql);
            rs_archive = statement_archive.executeQuery(sql);
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
            
        
        
        return rs_archive;
        
    }
    public ResultSet getResult(String name)
    { 
        ResultSet rs= null;
        rs = retrieve(name);
        try {
            conn_archive.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }
}
