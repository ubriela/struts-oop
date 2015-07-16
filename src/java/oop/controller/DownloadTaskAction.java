/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oop.controller;

/**
 *
 * @author PhuongNV
 */
import oop.model.services.*;
import oop.model.beans.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;

public class DownloadTaskAction extends DownloadAction {

    protected StreamInfo getStreamInfo(ActionMapping mapping, 
                                       ActionForm form,
                                       HttpServletRequest request, 
                                       HttpServletResponse response)
            throws Exception {
        
        // Download a "jpeg" file - gets the file name from the
        // Action Mapping's parameter
        String contentType         = null;
        ServletContext application = servlet.getServletContext();
        
        StoreBean storedFile= TeacherService.getTaskPath(Integer.parseInt(request.getParameter("exerciseId")),
                                                         request.getParameter("studentId"));
        // Set the content disposition
        response.setHeader("Content-disposition", 
                           "attachment; filename=\"" + storedFile.getFileName()+"\"");
        return new ResourceStreamInfo(contentType, application, storedFile.getURL());
        
    }

}
