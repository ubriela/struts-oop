<%-- 
    Document   : sendtask
    Created on : Oct 20, 2008, 9:41:03 PM
    Author     : PhuongNV
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

<html>
  <head>
      <META http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <title>Send Task </title>
    <link rel = "stylesheet" href = "styles.css" 
      type = "text/css" />
  </head>

  <body>
      <bean:parameter id="exerId" name="exerciseId" value=""/>
      <bean:parameter id="subjId" name="subjectId" value=""/>
      <html:form  action="/SendTask" method="post" enctype="multipart/form-data" acceptCharset="UTF-8" >
      <table width="500" border="0">
        <tr>
          <td>Mã môn học: <nested:text property="subjectId"  value="<%=subjId%>"/></td>
        </tr>
        <tr>
          <td>Mã bài tập: <nested:text property="exerciseId"  value="<%=exerId%>"/></td>
        </tr>
        <tr>
          <td>Bài làm: <html:file property="theFile" /> </td>
        </tr>
         <tr>
          <td>
            <html:submit>Nộp bài</html:submit>
          </td>
        </tr>
      </table>
    </html:form> 
  </body>
</html>
