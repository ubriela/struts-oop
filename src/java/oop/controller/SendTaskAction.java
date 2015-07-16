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

public class SendTaskAction extends Action {
    public ActionForward execute(ActionMapping mapping,
    ActionForm form,
    HttpServletRequest request,
    HttpServletResponse response)
    throws IOException, ServletException, Exception {

    // Default target to success
    String target = new String("success");
    
    SendTaskForm exerciseForm= (SendTaskForm) form;
    StudentExerciseBean exerciseBean= new StudentExerciseBean();
    //String utf= new String(exerciseForm.getName().getBytes("iso-8859-1"),"utf-8");
    exerciseBean.setExerciseId(exerciseForm.getExerciseId());
    exerciseBean.setSubjectId(exerciseForm.getSubjectId());

    
    HttpSession session = request.getSession( false );
    UserBean userbean= (UserBean)session.getAttribute("userbean");
    
    String DATE_FORMAT_NOW = "yyyyMMdd_HHmmss";
    String DATE_FORMAT_NOW1 = "yyyy-MM-dd";
    String now="";

    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW1);
    now= sdf.format(cal.getTime());
    exerciseBean.setDoneTime(now);
    
    sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    now= sdf.format(cal.getTime());
    
    // Process the FormFile
        FormFile myFile = exerciseForm.getTheFile();
        String contentType = myFile.getContentType();
    //Get the file name
        String fileName    = myFile.getFileName();
        String pureName= fileName;
        //int fileSize       = myFile.getFileSize();
        byte[] fileData    = myFile.getFileData();
    //Get the servers upload directory real path name
    String filePath = getServlet().getServletContext().getRealPath("/") +"store";
    // Save file on the server 
    if(!fileName.equals("")){  
        //Create file
        fileName= userbean.getUserId()+"_"+now+"_"+fileName;
        File fileToCreate = new File(filePath, fileName);
        //If file does not exists create file                      
        if(!fileToCreate.exists()){
          FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
          fileOutStream.write(myFile.getFileData());
          fileOutStream.flush();
          fileOutStream.close();
        }  
    }
    String fullName="\\store\\"+fileName; 
    
    StudentService.sendTask(userbean.getUserId(),exerciseBean,fullName,pureName);
    // Forward to the appropriate View
    
    ArrayList exercises = null;
        
    exercises= StudentService.getExercises(exerciseForm.getSubjectId(),userbean.getUserId());
    request.setAttribute("exercises", exercises);
    
    return (mapping.findForward(target));
  }
}
