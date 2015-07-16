/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oop.controller;

import oop.view.*;
import oop.model.beans.*;
import oop.model.services.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

/**
 *
 * @author PhuongNV
 */


public class RegisterAction extends Action {

  public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
      
      String target = new String("");
  
      try  
      { 
         RegisterForm registerForm= (RegisterForm) form;
         UserBean userbean= new UserBean();

         userbean.setUsername(registerForm.getUsername());
         userbean.setName(registerForm.getName());
         userbean.setPhone(registerForm.getPhone());
         userbean.setAddress(registerForm.getAddress());
         userbean.setEmail(registerForm.getEmail());
         userbean.setPassword(registerForm.getPassword());
         if(registerForm.getAutherCode()!="") userbean.setUsertype(2);
         else userbean.setUsertype(1);
         
         if (UserService.signUp(userbean,registerForm.getAutherCode())){
             target = new String("success"); 
         }
         else{
             target = new String("error"); 
         }
      } 
      catch ( Exception e )  
      { 
         target = new String("error"); 
         System.out.println( e.getMessage() ); 
      } 
      
       // Forward to the appropriate View
      return (mapping.findForward(target));
  }
  
  }