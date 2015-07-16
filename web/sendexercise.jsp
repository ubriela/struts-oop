<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

<html>
  <head>
      <META http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <title>Ma mon hoc: </title>
    <link rel = "stylesheet" href = "styles.css" 
      type = "text/css" />
  </head>

  <body>
      <bean:parameter id="subjId" name="subjectId" value=""/>
      <html:form  action="/SendExercise" method="post" enctype="multipart/form-data" acceptCharset="UTF-8" >
      <table width="500" border="0">
        <tr>
          <td>Mã môn học: <nested:text property="subjectId"  value="<%=subjId%>"/></td>
        </tr>
        <tr>
          <td>Tên bài tập: <html:text property="name" value="Toán rời rạc"/></td>
        </tr>
        <tr>
          <td>Thời hạn nộp (yyyy-mm-dd): <html:text property="deadline"/></td>
        </tr>
        <tr>
          <td>Phần trăm: <html:text property="percent" /></td>
        </tr>
        <tr>
          <td>Mô tả: <html:textarea property="description"/></td>
        </tr>
        <tr>
          <td>Đề bài: <html:file property="theFile" /> </td>
        </tr>
         <tr>
          <td>
            <html:submit>Giao bài</html:submit>
          </td>
        </tr>
      </table>
    </html:form> 
  </body>
</html>