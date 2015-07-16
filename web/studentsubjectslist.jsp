<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
  <head>
    <title>Student Subjects List</title>
  </head>
  <body>

    <table width="700"
      border="0" cellspacing="0" cellpadding="0">
      <tr align="left">
        <th>Subject ID</th>
        <th>Subject Name</th>
        <th>Lecturer ID</th>
        <th>Description</th>
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="subject" name="subjects">
	<tr align="left">
	  <td>
            <bean:write name="subject" property="subjectId" />
	  </td>
	  <td>
              <a href="StudentExercisesList.do?subjectId=<bean:write name="subject"
	      property="subjectId" />"><bean:write name="subject" property="subjectName" /></a>
	  </td>
	  <td>
            <bean:write name="subject" property="lecturerId" />
	  </td>
	  <td>
            <bean:write name="subject" property="description" />
	  </td>
	</tr>
      </logic:iterate>
      
    </table>
    <a href="StudentRegisterList.do">Đăng ký môn học</a>
  </body>
</html>