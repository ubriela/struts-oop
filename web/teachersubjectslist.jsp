<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
  <head>
    <title>Teacher Subjects List</title>
  </head>
  <body>
    
    <table width="800"
      border="0" cellspacing="0" cellpadding="0">
      <tr align="left">
        <th>Mã bài tập</th>
        <th>Tên bài tập</th>
        <th>Mã giảng viên</th>
        <th>Mô tả</th>
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="subject" name="subjects">
	<tr align="left">
	  <td>
            <bean:write name="subject" property="subjectId" />
	  </td>
	  <td>
              <a href="TeacherExercisesList.do?subjectId=<bean:write name="subject"
	      property="subjectId" />"><bean:write name="subject" property="subjectName" /></a>
	  </td>
	  <td>
            <bean:write name="subject" property="lecturerId" />
	  </td>
	  <td>
            <bean:write name="subject" property="description" />
	  </td>
          <td>
              <logic:equal name="subject" property="isLecturer"
                           value="yes" >
                    <a href="sendexerciseFCK.jsp?subjectId=<bean:write name="subject"
                    property="subjectId" />">Giao bài</a>
              </logic:equal>

	  </td>
          <td>
              <logic:equal name="subject" property="isLecturer"
                           value="yes" >
                   <a href="TeacherAssistantsList.do?subjectId=<bean:write name="subject"
                    property="subjectId" />">Thêm trợ giảng</a>
              </logic:equal>

	  </td>
          
	</tr>
      </logic:iterate>
      
    </table>
    <a href="TeacherRegisterList.do">Đăng ký môn học</a>
  </body>
</html>