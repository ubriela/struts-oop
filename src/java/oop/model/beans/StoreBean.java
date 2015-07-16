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
public class StoreBean {
    private int fileId;
    private String fileName;
    private String URL;
    private Date receivedTime;
    private int size;
    private String senderId;
    
    public int getFileId(){
        return fileId;
    }
    public void setfileId(int n){
        fileId= n;
    }
    
    public String getFileName(){
        return fileName;
    }
    public void setFileName(String n){
        fileName= n;
    }
    public int getSize(){
        return size;
    }
    public void setSize(int n){
        size= n;
    }
    public String getReceivedTime(){
        return receivedTime.toString();
    }
    public void setReceivedTime(String s){
        receivedTime= Date.valueOf(s);
    }
    public String getURL(){
        return URL;
    }
    public void setURL(String n){
        URL= n;
    }
    public String getSenderId(){
        return senderId;
    }
    public void setSenderId(String n){
        senderId= n;
    }
}
