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

import java.util.ArrayList;

/**
 *
 * @author PhuongNV
 */

public class TeacherRegisterListAction extends Action {
    public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException, Exception {

    // Default target to success
    String target = new String("success");

    ArrayList subjects = null;
    HttpSession session = request.getSession( false );
    UserBean userbean= (UserBean)session.getAttribute("userbean");
    subjects = TeacherService.getRegisterSubjects(userbean.getUserId());

    request.setAttribute("subjects", subjects);

    // Forward to the appropriate View
    return (mapping.findForward(target));
  }
}
