<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

<html>
  <head>
      <META http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <title>Teacher Exercises List</title>
    <link rel = "stylesheet" href = "styles.css" 
      type = "text/css" />
  </head>
  <body>
      <bean:parameter id="exerId" name="exerciseId" value=""/>
    
   <html:form action="/TaskSearch" acceptCharset="UTF-8">

        <table>
        <tr>
        <td align="right">Task Search: <nested:hidden property="exerciseId" value="<%=exerId%>" /></td>
        <td><html:text property="searchStr" value="String here..."/></td>
        </tr>
        <tr>
        <td></td>
        <td><html:submit value="Search"/></td>
        </tr>
        </table>

</html:form>

<logic:present name="exercises">

<hr width="100%" size="1" noshade="true">

<bean:size id="size" name="exercises"/>
<logic:equal name="size" value="0">
<center><font color="red"><b>No Task Found</b></font></center>
</logic:equal>

<logic:greaterThan name="size" value="0">

    <table width="1000"
      border="0" cellspacing="0" cellpadding="0">
      <tr align="left">
        <th>Exercise ID</th>
        <th>Exercise Name</th>
        <th>Deadline</th>
        <th>Percent</th>
        <th>Done Time</th>
        <th>Student Name</th>
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
              <bean:write name="exercise" property="name" />
	  </td>
	  <td>
            <bean:write name="exercise" property="deadline" />
	  </td>
          <td>
            <bean:write name="exercise" property="percent" />
	  </td>
          <td>
              <logic:notEqual name="exercise" property="doneTime"
                           value="" >
                    <a href="DownloadTask.do?exerciseId=<bean:write name="exercise"
                    property="exerciseId" />&studentId=<bean:write name="exercise"
                    property="studentId" />"><bean:write name="exercise" property="doneTime" /></a>
              </logic:notEqual>
	  </td>
          <td>
            <bean:write name="exercise" property="studentName" />
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
                    <a href="gradetask.jsp?exerciseId=<bean:write name="exercise"
                    property="exerciseId" />&studentId=<bean:write name="exercise"
                    property="studentId" />">Chấm bài</a>
              </logic:equal>

	  </td>
	</tr>
      </logic:iterate>
    </table>
    </logic:greaterThan>

</logic:present>
  </body>
</html>