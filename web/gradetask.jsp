<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

<html>
  <head>
      <META http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <title>Grade Task </title>
    <link rel = "stylesheet" href = "styles.css" 
      type = "text/css" />
  </head>

  <body>
      <bean:parameter id="exerId" name="exerciseId" value=""/>
      <bean:parameter id="studId" name="studentId" value=""/>
      <html:form  action="/GradeTask">
      <table width="500" border="0">
        <tr>
          <td>Mã sinh viên: <nested:text property="studentId"  value="<%=studId%>"/></td>
        </tr>
        <tr>
          <td>Mã bài tập: <nested:text property="exerciseId"  value="<%=exerId%>"/></td>
        </tr>
        <tr>
          <td>Nhận xét: <html:textarea property="comment"/></td>
        </tr>
        <tr>
          <td>Điểm: <html:text property="score" /></td>
        </tr>
         <tr>
          <td>
            <html:submit>Chấm bài</html:submit>
          </td>
        </tr>
      </table>
    </html:form> 
  </body>
</html>
