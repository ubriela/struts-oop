/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oop.model.beans;

/**
 *
 * @author PhuongNV
 */
public class SubjectBean {
    private int subjectId;
    private String subjectName;
    private String lecturerId;
    private String description;
    private String isLecturer;
    
     public int getSubjectId(){
        return subjectId;
    }
    public void setSubjectId(int id){
        subjectId= id;
    }
    public String getSubjectName(){
        return subjectName;
    }
    public void setSubjectName(String nam){
        subjectName= nam;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String pass){
        description= pass;
    }
    public String getLecturerId(){
        return lecturerId;
    }
    public void setLecturerId(String type){
        lecturerId= type;
    }
    public String getIsLecturer(){
        return isLecturer;
    }
    public void setIsLecturer(String id){
        isLecturer= id;
    }
}
