package oop.model.services;

import oop.model.beans.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.CallableStatement; 
import java.sql.Date;
import java.util.Calendar;

import java.util.ArrayList;

public class StudentService extends UserService {
    public static ArrayList getSubjects(String userId) 
            throws Exception 
    {
        ArrayList subjects= new ArrayList();
        SubjectBean subjectbean= new SubjectBean();
        
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop","phuongnv","phuongnv");
        CallableStatement cs = connect.prepareCall("{call sp_list_sinhvien_monhoc(?)}");
        cs.setString("MaSV", userId);
        ResultSet result = cs.executeQuery();
        while (result.next()){
            subjectbean= new SubjectBean();
            subjectbean.setSubjectId(result.getInt("MaMH"));
            subjectbean.setSubjectName(result.getString("TenMH"));
            subjectbean.setLecturerId(result.getString("MaGVChinh"));
            subjectbean.setDescription(result.getString("MoTa"));
            
            subjects.add(subjectbean);
        }
        return subjects;                    
        
    }
    
    public static ArrayList getExercises(int subjectId, String userId) 
            throws Exception 
    {
        ArrayList exercises= new ArrayList();
        StudentExerciseBean exercisebean= new StudentExerciseBean();
        
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop","phuongnv","phuongnv");
        CallableStatement cs = connect.prepareCall("{call sp_list_sinhvien_baitap(?,?)}");
        cs.setInt("MaMH", subjectId);
        cs.setString("MaSV", userId);
        ResultSet result = cs.executeQuery();
        while (result.next()){
            exercisebean= new StudentExerciseBean();
            exercisebean.setSubjectId(result.getInt("MaMH"));
            exercisebean.setExerciseId(result.getInt("MaBT"));
            exercisebean.setName(result.getString("TenBT"));
            exercisebean.setDeadline(result.getDate("thNopBai").toString());
            exercisebean.setPercent(result.getInt("PhanTram"));
            exercisebean.setDescription(result.getString("MoTa"));
            exercisebean.setScore(result.getInt("Diem"));
            
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, -4);
            if(result.getDate("thNopbai").after(cal.getTime()))
                exercisebean.setIsOutOfDate("no");
            else
                exercisebean.setIsOutOfDate("yes");
            
            if((result.getDate("tgNopBai")==null))
                exercisebean.setDoneTime("");
            else
            {
                exercisebean.setDoneTime(result.getDate("tgNopBai").toString());
                exercisebean.setIsOutOfDate("yes");
            }
            exercisebean.setComment(result.getString("DanhGia"));
            exercisebean.setGraderId(result.getString("NguoiCham"));
            if(result.getInt("MaLoiGiai")!=0)
                exercisebean.setIsDownCorrectable("yes");
            else
                exercisebean.setIsDownCorrectable("no");
            exercises.add(exercisebean);
        }
        return exercises;                    
        
    }
    public static StoreBean getExercisePath(int exerciseId) 
            throws Exception 
    {
        StoreBean storedFile= new StoreBean();
        
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop","phuongnv","phuongnv");
        CallableStatement cs = connect.prepareCall("{call sp_get_baitap_path(?)}");
        cs.setInt("MaBT", exerciseId);
        ResultSet result = cs.executeQuery();
        if (result.next()){
            storedFile.setURL(result.getString("URL"));
            storedFile.setFileName(result.getString("TenFile"));
        }
        return storedFile;                    
        
    }
    public static StoreBean getCorrectedPath(int exerciseId) 
            throws Exception 
    {
        StoreBean storedFile= new StoreBean();
        
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop","phuongnv","phuongnv");
        CallableStatement cs = connect.prepareCall("{call sp_get_baitap_loigiai(?)}");
        cs.setInt("MaBT", exerciseId);
        ResultSet result = cs.executeQuery();
        if (result.next()){
            storedFile.setURL(result.getString("URL"));
            storedFile.setFileName(result.getString("TenFile"));
        }
        return storedFile;                    
        
    }
    
    public static void sendTask(String userId,StudentExerciseBean exercise,String fullName,String fileName) 
            throws Exception 
    {
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop?useUnicode=true&characterEncoding=utf8","phuongnv","phuongnv");
        //st.executeQuery("SET NAMES 'utf8'");
        //st.executeQuery("SET CHARACTER SET utf8");
        CallableStatement cs = connect.prepareCall("{call sp_send_sinhvien_task(?,?,?,?,?)}");
        cs.setString("MaSV", userId);
        cs.setInt("MaBT", exercise.getExerciseId());
        cs.setString("tgNop", exercise.getDoneTime());
        cs.setString("URL", fullName);
        cs.setString("TenFile", fileName);
        
        ResultSet result = cs.executeQuery();                   
        
    }
    public static ArrayList getRegisterSubjects(String userId) 
            throws Exception 
    {
        ArrayList subjects= new ArrayList();
        SubjectBean subjectbean= new SubjectBean();
        
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop","phuongnv","phuongnv");
        CallableStatement cs = connect.prepareCall("{call sp_list_sinhvien_dangky(?)}");
        cs.setString("MaSV", userId);
        ResultSet result = cs.executeQuery();
        while (result.next()){
            subjectbean= new SubjectBean();
            subjectbean.setSubjectId(result.getInt("MaMH"));
            subjectbean.setSubjectName(result.getString("TenMH"));
            subjectbean.setLecturerId(result.getString("MaGVChinh"));
            subjectbean.setDescription(result.getString("MoTa"));
            
            subjects.add(subjectbean);
        }
        return subjects;                    
        
    }
    public static void enroll(String userId,int subjectId) 
            throws Exception 
    {
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop?useUnicode=true&characterEncoding=utf8","phuongnv","phuongnv");
        //st.executeQuery("SET NAMES 'utf8'");
        //st.executeQuery("SET CHARACTER SET utf8");
        CallableStatement cs = connect.prepareCall("{call sp_dangky_sinhvien_monhoc(?,?)}");
        cs.setString("MaSV", userId);
        cs.setInt("MaMH", subjectId);
        
        ResultSet result = cs.executeQuery();                   
        
    }
}