/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oop.model.beans;

import java.sql.Date;

/**
 *
 * @author PhuongNV
 */
public class StudentExerciseBean {
    private int exerciseId;
    private int subjectId;
    private String name;
    private int storeId;
    private Date deadline;
    private int percent;
    private String description;
    private int correctStoreId;
    private int score;
    private Date doneTime;
    private int taskStoreId;
    private String comment;
    private String graderId;
    private String graderName;
    private String studentId;
    private String studentName;
    private String isOutOfDate;
    private String isDownCorrectable;

    public String getIsDownCorrectable() {
        return isDownCorrectable;
    }

    public void setIsDownCorrectable(String isDownCorrectable) {
        this.isDownCorrectable = isDownCorrectable;
    }
    
    
    public int getExerciseId(){
        return exerciseId;
    }
    public void setExerciseId(int n){
        exerciseId= n;
    }
    public int getSubjectId(){
        return subjectId;
    }
    public void setSubjectId(int n){
        subjectId= n;
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        name= n;
    }
    public int getStoreId(){
        return storeId;
    }
    public void setStoreId(int n){
        storeId= n;
    }
    public String getDeadline(){
        return deadline.toString();
    }
    public void setDeadline(String s){
        deadline= Date.valueOf(s);
    }
    public int getPercent(){
        return percent;
    }
    public void setPercent(int n){
        percent= n;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String n){
        description= n;
    }
    public int getCorrectStoreId(){
        return correctStoreId;
    }
    public void setCorrectStoreId(int n){
        correctStoreId= n;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int n){
        score= n;
    }
    public String getDoneTime(){
       if(doneTime != null) 
            return doneTime.toString();
       else
           return "";
    }
    public void setDoneTime(String s){
        if(s != "")
            doneTime= Date.valueOf(s);
    }
    public int getTaskStoreId(){
        return taskStoreId;
    }
    public void setTaskStoreId(int n){
        taskStoreId= n;
    }
    public String getComment(){
        return comment;
    }
    public void setComment(String n){
        comment= n;
    }
    public String getGraderId(){
        return graderId;
    }
    public void setGraderId(String n){
        graderId= n;
    }
    public String getGraderName(){
        return graderName;
    }
    public void setGraderName(String n){
        graderName= n;
    }
    public String getStudentId(){
        return studentId;
    }
    public void setStudentId(String n){
        studentId= n;
    }
    public String getStudentName(){
        return studentName;
    }
    public void setStudentName(String n){
        studentName= n;
    }
    public String getIsOutOfDate(){
        return isOutOfDate;
    }
    public void setIsOutOfDate(String n){
        isOutOfDate= n;
    }
}
