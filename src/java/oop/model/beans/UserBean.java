/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oop.model.beans;

/**
 *
 * @author PhuongNV
 */
public class UserBean {
    private String userId;
    private String username;
    private String password;
    private int usertype;
    private String name;
    private String email;
    private int phone;
    private String address;
    private String message;
    
    public UserBean (){
        userId="";
        username="";
        password="";
        usertype=0;
        name="";
        email="";
        phone=0;
        address="";
        message="";
    }
    
    public String getUserId(){
        return userId;
    }
    public void setUserId(String id){
        userId= id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String nam){
        username= nam;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String pass){
        password= pass;
    }
    public int getUsertype(){
        return usertype;
    }
    public void setUsertype(int type){
        usertype= type;
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        name= n;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String n){
        email= n;
    }
    public int getPhone(){
        return phone;
    }
    public void setPhone(int n){
        phone= n;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String n){
        address= n;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String n){
        message= n;
    }
}
