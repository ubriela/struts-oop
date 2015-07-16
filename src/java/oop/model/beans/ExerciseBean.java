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
public class ExerciseBean {
    private int exerciseId;
    private int subjectId;
    private String name;
    private int storeId;
    private Date deadline;
    private int percent;
    private String description;
    private int correctStoreId;
    private String isSendCorrectable;

    public String getIsSendCorrectable() {
        return isSendCorrectable;
    }

    public void setIsSendCorrectable(String isSendCorrectable) {
        this.isSendCorrectable = isSendCorrectable;
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
}
