package oop.model.services;

import oop.model.beans.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.CallableStatement; 
import java.sql.Statement; 
import java.sql.Date;
import java.util.Calendar;

import java.util.ArrayList;

public class TeacherService extends UserService {
    public static ArrayList getSubjects(String userId) 
            throws Exception 
    {
        ArrayList subjects= new ArrayList();
        SubjectBean subjectbean= new SubjectBean();
        
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop","phuongnv","phuongnv");
        CallableStatement cs = connect.prepareCall("{call sp_list_giangvien_monhoc(?)}");
        cs.setString("MaGV", userId);
        ResultSet result = cs.executeQuery();
        while (result.next()){
            subjectbean= new SubjectBean();
            subjectbean.setSubjectId(result.getInt("MaMH"));
            subjectbean.setSubjectName(result.getString("TenMH"));
            subjectbean.setLecturerId(result.getString("MaGVChinh"));
            subjectbean.setDescription(result.getString("MoTa"));
            if (result.getString("MaGVChinh").equals(userId))
                subjectbean.setIsLecturer("yes");
            else 
                subjectbean.setIsLecturer("no");
            
            subjects.add(subjectbean);
        }
        return subjects;                    
        
    }
    public static ArrayList getExercises(int subjectId) 
            throws Exception 
    {
        ArrayList exercises= new ArrayList();
        ExerciseBean exercisebean= new ExerciseBean();
        
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop","phuongnv","phuongnv");
        CallableStatement cs = connect.prepareCall("{call sp_list_giangvien_baitap(?)}");
        cs.setInt("MaMH", subjectId);
        ResultSet result = cs.executeQuery();
        while (result.next()){
            exercisebean= new ExerciseBean();
            exercisebean.setExerciseId(result.getInt("MaBT"));
            exercisebean.setSubjectId(result.getInt("MaMH"));
            exercisebean.setName(result.getString("TenBT"));
            exercisebean.setStoreId(result.getInt("MaDe"));
            exercisebean.setDeadline(result.getDate("tgNopBai").toString());
            exercisebean.setPercent(result.getInt("PhanTram"));
            exercisebean.setDescription(result.getString("MoTa"));
            exercisebean.setCorrectStoreId(result.getInt("MaLoiGiai"));
            
            Calendar cal = Calendar.getInstance();
            if(result.getDate("tgNopbai").before(cal.getTime()))
                exercisebean.setIsSendCorrectable("yes");
            else
                exercisebean.setIsSendCorrectable("no");
            
            exercises.add(exercisebean);
        }
        return exercises;                    
        
    }
    public static ArrayList getStudentTasks(int exerciseId) 
            throws Exception 
    {
        ArrayList exercises= new ArrayList();
        StudentExerciseBean exercisebean= new StudentExerciseBean();
        
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop","phuongnv","phuongnv");
        CallableStatement cs = connect.prepareCall("{call sp_list_giangvien_sinhvien_tasks(?)}");
        cs.setInt("MaBT", exerciseId);
        ResultSet result = cs.executeQuery();
        while (result.next()){
            exercisebean= new StudentExerciseBean();
            exercisebean.setExerciseId(result.getInt("MaBT"));
            exercisebean.setStudentId(result.getString("MaSV"));
            exercisebean.setStudentName(result.getString("TenSV"));
            exercisebean.setName(result.getString("TenBT"));
            exercisebean.setTaskStoreId(result.getInt("MaBaiLam"));
            exercisebean.setDeadline(result.getDate("thNopBai").toString());
            if((result.getDate("tgNopBai")==null))
                exercisebean.setDoneTime("");
            else
            {
                exercisebean.setDoneTime(result.getDate("tgNopBai").toString());
                exercisebean.setIsOutOfDate("no");
            }
            exercisebean.setPercent(result.getInt("PhanTram"));
            exercisebean.setScore(result.getInt("Diem"));
            exercisebean.setComment(result.getString("DanhGia"));
            exercisebean.setGraderId(result.getString("NguoiCham"));
            //exercisebean.setGraderName(result.getString("TenNguoiCham"));
            
            exercises.add(exercisebean);
        }
        return exercises;                    
        
    }
    public static StoreBean getTaskPath(int exerciseId,String studentId) 
            throws Exception 
    {
        StoreBean storedFile= new StoreBean();
        
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop","phuongnv","phuongnv");
        CallableStatement cs = connect.prepareCall("{call sp_get_sinhvien_task(?,?)}");
        cs.setInt("MaBT", exerciseId);
        cs.setString("MaSV", studentId);
        ResultSet result = cs.executeQuery();
        if (result.next()){
            storedFile.setURL(result.getString("URL"));
            storedFile.setFileName(result.getString("TenFile"));
        }
        return storedFile;                    
        
    }
    public static void gradeTask(StudentExerciseBean exercise,String graderId) 
            throws Exception 
    {
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop?useUnicode=true&characterEncoding=utf8","phuongnv","phuongnv");
        Statement stmt = connect.createStatement(); 
        ResultSet result = stmt.executeQuery( "SELECT tbl_baitap.tgNopBai as thoihan,tbl_baitap.PhanTram,tbl_sinhvien_baitap.tgNopBai " 
                                                + "FROM tbl_baitap,tbl_sinhvien_baitap "
                                                + "WHERE tbl_baitap.MaBT="+exercise.getExerciseId()+" and "
                                                + "tbl_sinhvien_baitap.MaBT="+exercise.getExerciseId()+" and tbl_sinhvien_baitap.UserID= \""+exercise.getStudentId()+"\"");
                                            
        if (result.next()){
            Date done= result.getDate("tgNopBai");
            Date dead= result.getDate("thoihan");
            int percent= result.getInt("PhanTram");
            if(done.after(dead)) 
                exercise.setScore(exercise.getScore()*(100-percent)/100);
        }
            
        //st.executeQuery("SET NAMES 'utf8'");
        //st.executeQuery("SET CHARACTER SET utf8");
        CallableStatement cs = connect.prepareCall("{call sp_grade_sinhvien_task(?,?,?,?,?)}");
        cs.setInt("MaBT", exercise.getExerciseId());
        cs.setString("MaSV", exercise.getStudentId());
        cs.setInt("Diem", exercise.getScore());
        cs.setString("DanhGia", exercise.getComment());
        cs.setString("NguoiCham", graderId);
        
        result = cs.executeQuery();            
    }
    public static ArrayList getRegisterSubjects(String userId) 
            throws Exception 
    {
        ArrayList subjects= new ArrayList();
        SubjectBean subjectbean= new SubjectBean();
        
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop","phuongnv","phuongnv");
        Statement stmt = connect.createStatement(); 
        ResultSet result = stmt.executeQuery( "SELECT MaMH,TenMH,MoTa FROM tbl_monhoc WHERE MaGVChinh= ''" );
        while (result.next()){
            subjectbean= new SubjectBean();
            subjectbean.setSubjectId(result.getInt("MaMH"));
            subjectbean.setSubjectName(result.getString("TenMH"));
            //subjectbean.setLecturerId(result.getString("MaGVChinh"));
            subjectbean.setDescription(result.getString("MoTa"));
            
            subjects.add(subjectbean);
        }
        return subjects;                    
        
    }
    public static void registerSubject(String userId,int subjectId) 
            throws Exception 
    {
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop?useUnicode=true&characterEncoding=utf8","phuongnv","phuongnv");
        //st.executeQuery("SET NAMES 'utf8'");
        //st.executeQuery("SET CHARACTER SET utf8");
        //Statement stmt = connect.createStatement(); 
        //ResultSet result = stmt.executeQuery( "INSERT INTO oop.tbl_monhoc_giangvien (MaMH,UserID) VALUE ("+subjectId+",'"+userId+"')");           
        CallableStatement cs = connect.prepareCall("{call sp_dangky_giangvien_monhoc(?,?)}");
        cs.setString("MaGV", userId);
        cs.setInt("MaMH", subjectId);
        
        ResultSet result = cs.executeQuery();      
        
    }
    public static ArrayList searchTask(int exerciseId, String searchStr) 
            throws Exception 
    {
        ArrayList exercises= new ArrayList();
        StudentExerciseBean exercisebean= new StudentExerciseBean();
        
        Class.forName( "com.mysql.jdbc.Driver" ); 
        Connection connect = DriverManager.getConnection ("jdbc:mysql://localhost/oop?useUnicode=true&characterEncoding=utf8","phuongnv","phuongnv");
        CallableStatement cs = connect.prepareCall("{call sp_list_giangvien_sinhvien_tasksearch(?,?)}");
        cs.setInt("MaBT", exerciseId);
        cs.setString("TimKiem", "%"+searchStr+"%");
        ResultSet result = cs.executeQuery();
        while (result.next()){
            exercisebean= new StudentExerciseBean();
            exercisebean.setExerciseId(result.getInt("MaBT"));
            exercisebean.setStudentId(result.getString("MaSV"));
            exercisebean.setStudentName(result.getString("TenSV"));
            exercisebean.setName(result.getString("TenBT"));
            exercisebean.setTaskStoreId(result.getInt("MaBaiLam"));
            exercisebean.setDeadline(result.getDate("thNopBai").toString());
            if((result.getDate("tgNopBai")==null))
                exercisebean.setDoneTime("");
            else
            {
                exercisebean.setDoneTime(result.getDate("tgNopBai").toString());
                exercisebean.setIsOutOfDate("no");
            }
            exercisebean.setPercent(result.getInt("PhanTram"));
            exercisebean.setScore(result.getInt("Diem"));
            exercisebean.setComment(result.getString("DanhGia"));
            exercisebean.setGraderId(result.getString("NguoiCham"));
            //exercisebean.setGraderName(result.getString("TenNguoiCham"));
            
            exercises.add(exercisebean);
        }
        return exercises;                    
        
    }
}
