<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
  <head>
    <title>Teacher Register Assistants List</title>
  </head>
  <body>
    <bean:parameter id="subjId" name="subjectId" value=""/>
    <table width="700"
      border="0" cellspacing="0" cellpadding="0">
      <tr align="left">
        <th>User ID</th>
        <th>Name</th>
        <th>Diploma</th>
        <th>Department</th>
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="assistant" name="assistants">
	<tr align="left">
	  <td>
            <bean:write name="assistant" property="userId" />
	  </td>
	  <td>
              <bean:write name="assistant" property="name" />
	  </td>
	  <td>
            <bean:write name="assistant" property="diploma" />
	  </td>
          <td>
            <bean:write name="assistant" property="department" />
	  </td>
          <td>
            <a href="TeacherRegisterAssistant.do?subjectId=<%=subjId%>&userId=<bean:write name="assistant"
	      property="userId" />">Thêm trợ giảng</a>
	  </td>
	</tr>
      </logic:iterate>
    </table>
  </body>
</html>