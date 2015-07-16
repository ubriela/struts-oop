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
public class ExerciseForm extends ActionForm {
    private int subjectId;
    private String name;
    private int percent;
    private Date deadline;
    private String description;
    private FormFile theFile;
    private String contentStr;

    public String getContentStr() {
        return contentStr;
    }

    public void setContentStr(String contentStr) {
        this.contentStr = contentStr;
    }
    
    
    public int getSubjectId(){
        return subjectId;
    }
    public void setSubjectId(int n){
        subjectId= n;
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        name= n;
    }
    public String getDeadline(){
        if(deadline != null) 
            return deadline.toString();
       else
           return "";
    }
    public void setDeadline(String s){
        if(!s.equals(""))
            deadline= Date.valueOf(s);
    }
    public int getPercent(){
        return percent;
    }
    public void setPercent(int n){
        percent= n;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String n){
        description= n;
    }
    public FormFile getTheFile(){
        return theFile;
    }
    public void setTheFile(FormFile n){
        this.theFile= n;
    }
    public void reset(ActionMapping mapping, HttpServletRequest request){
        subjectId=0;
        name="";
        percent=0;
        deadline=null;
        description="";
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
        subjectId= i.intValue();
        if (name==null || name.length()==0)
            errors.add("Name", new ActionError("Name is required"));
        if (description==null || description.length()==0)
            errors.add("Percent", new ActionError("percent is required"));
        
        return errors;
    }
}