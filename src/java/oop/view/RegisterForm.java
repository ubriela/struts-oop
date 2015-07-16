/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oop.view;

/**
 *
 * @author PhuongNV
 */
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import java.sql.Date;
import java.io.UnsupportedEncodingException;


public class RegisterForm extends ActionForm {
    private String userId;
    private String username;
    private String password;
    private int usertype;
    private String name;
    private String email;
    private int phone;
    private String address;
    private String message;
    private String autherCode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAutherCode() {
        return autherCode;
    }

    public void setAutherCode(String autherCode) {
        this.autherCode = autherCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }
    public void reset(ActionMapping mapping, HttpServletRequest request){
        username="";
        password="";
        try{
            request.setCharacterEncoding("UTF-8");
        }
        catch(UnsupportedEncodingException exc ){
            
        }
    }

}
