package oop.model.services;

import oop.model.beans.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.CallableStatement; 
import java.sql.Statement; 

public class UserService {
    public static boolean signIn (String username, String password, UserBean userbean) 
            throws Exception 
    {
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop","phuongnv","phuongnv");
        Statement stmt = connect.createStatement(); 
        ResultSet result = stmt.executeQuery( "select * from tbl_nguoidung where UserName='"+username+"' and Password='"+password+"'" );   
        if (result.next()){
            userbean.setUserId(result.getString("UserID"));
            userbean.setUsername(result.getString("UserName"));
            userbean.setPassword(result.getString("Password"));
            userbean.setUsertype(result.getInt("UserType"));
            userbean.setName(result.getString("HoTen"));
            userbean.setEmail(result.getString("Email"));
            userbean.setPhone(result.getInt("SoDT"));
            userbean.setAddress(result.getString("DiaChi"));
            userbean.setMessage(result.getString("TinNhan"));
            
            return true;
        }
                            
        return false;
    }
    public static boolean signUp (UserBean userbean, String authenCode) 
            throws Exception 
    {
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop?useUnicode=true&characterEncoding=utf8","phuongnv","phuongnv");
        CallableStatement cs = connect.prepareCall("{call sp_add_nguoidung(?,?,?,?,?,?,?,?)}");
        Statement stmt = connect.createStatement(); 
        ResultSet result = stmt.executeQuery( "SELECT UserID FROM tbl_nguoidung ORDER BY CAST(UserID AS UNSIGNED) DESC" );
        String lastID="";
        if(result.next()) lastID= result.getString("UserID");
        result= stmt.executeQuery( "SELECT * FROM tbl_nguoidung WHERE UserName= '"+userbean.getUsername()+"'" );
        if(result.next()) return false;
        if(userbean.getUsertype()==2)
        {
            if(!authenCode.equals("123456")) return false;
        }
        
        cs.setString("UserID", Integer.toString(Integer.parseInt(lastID)+1));
        cs.setString("Username", userbean.getUsername());
        cs.setString("iPassword", userbean.getPassword());
        cs.setString("HoTen",userbean.getName());
        cs.setString("Email", userbean.getEmail());
        cs.setString("DiaChi", userbean.getAddress());
        cs.setInt("SoDT", userbean.getPhone());
        cs.setInt("UserType",userbean.getUsertype());

        cs.executeQuery();
        return true;
    }
}
