/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oop.view;

import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
/**
 *
 * @author PhuongNV
 */
public class LoginForm extends ActionForm {
    private String username;
    private String password;
    
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setUsername(String name) {
        username= name;
    }
    public void setPassword(String pass) {
        password= pass;
    }
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        username= "";
        password= "";
    }
    
    public ActionErrors validate(ActionMapping mapping,
    HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (username==null || username.length()==0)
            errors.add("Username", new ActionError("Username is required"));
        if (password==null || password.length()==0)
            errors.add("Password", new ActionError("Password is required"));
        return errors;
    }
    
}
