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
import java.sql.Date;
import org.apache.struts.upload.FormFile;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author PhuongNV
 */
public class SendTaskForm extends ActionForm {
    private int exerciseId;
    private int subjectId;
    private FormFile theFile;
    private String contentStr;

    public String getContentStr() {
        return contentStr;
    }

    public void setContentStr(String contentStr) {
        this.contentStr = contentStr;
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
    public FormFile getTheFile(){
        return theFile;
    }
    public void setTheFile(FormFile n){
        this.theFile= n;
    }
    public void reset(ActionMapping mapping, HttpServletRequest request){
        exerciseId=0;
        try{
            request.setCharacterEncoding("UTF-8");
        }
        catch(UnsupportedEncodingException exc ){
            
        }
    }
    
    public ActionErrors validate(ActionMapping mapping,
    HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        Integer i= (Integer) request.getAttribute("subjectId");
        exerciseId= i.intValue();

        return errors;
    }
}