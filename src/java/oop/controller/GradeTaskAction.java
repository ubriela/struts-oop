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
import org.apache.struts.upload.FormFile;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.*;

/**
 *
 * @author PhuongNV
 */
public class GradeTaskAction extends Action {
    public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException, Exception {

    // Default target to success
    String target = new String("success");
    GradeTaskForm exerciseForm= (GradeTaskForm) form;
    StudentExerciseBean exerciseBean= new StudentExerciseBean();
    
    exerciseBean.setExerciseId(exerciseForm.getExerciseId());
    exerciseBean.setStudentId(exerciseForm.getStudentId());
    exerciseBean.setScore(exerciseForm.getScore());
    String utf= new String(exerciseForm.getComment().getBytes("iso-8859-1"),"utf-8");
    exerciseBean.setComment(utf);
    
    HttpSession session = request.getSession( false );
    UserBean userbean= (UserBean)session.getAttribute("userbean");
    
    TeacherService.gradeTask(exerciseBean,userbean.getUserId());
    
    ArrayList exercises = null;
        
    exercises= TeacherService.getStudentTasks(exerciseForm.getExerciseId());
    request.setAttribute("exercises", exercises);

    // Forward to the appropriate View
    return (mapping.findForward(target));
    
    }

}
