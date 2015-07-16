package oop.model.services;

import oop.model.beans.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.CallableStatement; 
import java.sql.Statement; 
import java.sql.Date;
import org.apache.struts.upload.FormFile;

import java.util.ArrayList;

public class LecturerService extends TeacherService {
    public static void sendExerice(String userId,StudentExerciseBean exercise,String fullName,String fileName) 
            throws Exception 
    {
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop?useUnicode=true&characterEncoding=utf8","phuongnv","phuongnv");
        Statement st= connect.createStatement();
        //st.executeQuery("SET NAMES 'utf8'");
        //st.executeQuery("SET CHARACTER SET utf8");
        CallableStatement cs = connect.prepareCall("{call sp_send_baitap(?,?,?,?,?,?,?,?)}");
        cs.setString("MaGV", userId);
        cs.setInt("MaMH", exercise.getSubjectId());
        cs.setString("TenBT", exercise.getName());
        cs.setString("tgNopBai", exercise.getDeadline());
        cs.setInt("PhanTram", exercise.getPercent());
        cs.setString("MoTa", exercise.getDescription());
        cs.setString("URL", fullName);
        cs.setString("TenFile", fileName);
        
        ResultSet result = cs.executeQuery();                   
        
    }
    public static void sendCorrected(String userId,StudentExerciseBean exercise,String fullName,String fileName) 
            throws Exception 
    {
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop?useUnicode=true&characterEncoding=utf8","phuongnv","phuongnv");
        //st.executeQuery("SET NAMES 'utf8'");
        //st.executeQuery("SET CHARACTER SET utf8");
        CallableStatement cs = connect.prepareCall("{call sp_send_baitap_corrected(?,?,?,?,?)}");
        cs.setString("MaGV", userId);
        cs.setInt("MaBT", exercise.getExerciseId());
        cs.setString("tgNop", exercise.getDoneTime());
        cs.setString("URL", fullName);
        cs.setString("TenFile", fileName);
        
        ResultSet result = cs.executeQuery();                   
        
    }
    public static ArrayList getRegisterAssistants(int subjectId) 
            throws Exception 
    {
        ArrayList assistants= new ArrayList();
        TeacherBean teacherbean= new TeacherBean();
        
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop","phuongnv","phuongnv");
        CallableStatement cs = connect.prepareCall("{call sp_list_dangky_trogiang(?)}");
        cs.setInt("MaMH", subjectId);
        ResultSet result = cs.executeQuery();
        while (result.next()){
            teacherbean= new TeacherBean();
            teacherbean.setName(result.getString("HoTen"));
            teacherbean.setUserId(result.getString("UserID"));
            teacherbean.setDiploma(result.getString("HocVi"));
            teacherbean.setDepartment(result.getString("Khoa"));
            
            assistants.add(teacherbean);
        }
        return assistants;                    
        
    }
    public static void registerAssistant(int subjectId,String userId) 
            throws Exception 
    {
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop?useUnicode=true&characterEncoding=utf8","phuongnv","phuongnv");
        //st.executeQuery("SET NAMES 'utf8'");
        //st.executeQuery("SET CHARACTER SET utf8");
        //Statement stmt = connect.createStatement(); 
        //ResultSet result = stmt.executeQuery( "INSERT INTO oop.tbl_monhoc_giangvien (MaMH,UserID) VALUE ("+subjectId+",'"+userId+"')");           
        CallableStatement cs = connect.prepareCall("{call sp_dangky_trogiang_monhoc(?,?)}");
        cs.setString("MaGV", userId);
        cs.setInt("MaMH", subjectId);
        
        ResultSet result = cs.executeQuery();      
        
    }
}