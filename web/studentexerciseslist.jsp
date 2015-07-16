<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
  <head>
    <title>Teacher Exercises List</title>
  </head>
  <body>

    <table width="1000"
      border="0" cellspacing="0" cellpadding="0">
      <tr align="left">
        <th>Exercise ID</th>
        <th>Exercise Name</th>
        <th>Deadline</th>
        <th>Percent</th>
        <th>Description</th>
        <th>Done Time</th>
        <th>Score</th>
        <th>Comment</th>
        <th>Grader</th>
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="exercise" name="exercises">
	<tr align="left">
	  <td>
            <bean:write name="exercise" property="exerciseId" />
	  </td>
	  <td>
              <a href="DownloadExercise.do?exerciseId=<bean:write name="exercise" 
              property="exerciseId" />"><bean:write name="exercise" property="name" /></a>
	  </td>
	  <td>
            <bean:write name="exercise" property="deadline" />
	  </td>
          <td>
            <bean:write name="exercise" property="percent" />
	  </td>
	  <td>
            <bean:write name="exercise" property="description" />
	  </td>
          <td>
            <bean:write name="exercise" property="doneTime" />
	  </td>
          <td>
              <logic:notEqual name="exercise" property="score" value="0" >
                    <bean:write name="exercise" property="score" />
              </logic:notEqual>
            
	  </td>
          <td>
            <bean:write name="exercise" property="comment" />
	  </td>
          <td>
            <bean:write name="exercise" property="graderId" />
	  </td>
          <td>
              <logic:equal name="exercise" property="isOutOfDate"
                           value="no" >
                    <a href="sendtaskFCK.jsp?subjectId=<bean:write name="exercise"
                    property="subjectId" />&exerciseId=<bean:write name="exercise"
                    property="exerciseId" />">Nộp bài</a>
              </logic:equal>

	  </td>
          <td>
              <logic:equal name="exercise" property="isDownCorrectable"
                           value="yes" >
                    <a href="DownloadCorrected.do?exerciseId=<bean:write name="exercise"
                    property="exerciseId" />">Bài chữa</a>
              </logic:equal>

	  </td>
	</tr>
      </logic:iterate>
    </table>
  </body>
</html>