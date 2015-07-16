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


public class LoginAction extends Action {

  public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException {
      
      String target = new String("success");
  
      try  
      { 
         LoginForm loginForm= (LoginForm) form;
         UserBean userbean= new UserBean();
         
         if (UserService.signIn(loginForm.getUsername(), loginForm.getPassword(), userbean)){
             HttpSession session = request.getSession(false);
             session.setAttribute("userbean", userbean);
             if (userbean.getUsertype()==1) {
                 target= new String("student");
             }
             if (userbean.getUsertype()==2) {
                 target= new String("teacher");
             }
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