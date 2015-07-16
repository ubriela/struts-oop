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

    <table width="700"
      border="0" cellspacing="0" cellpadding="0">
      <tr align="left">
        <th>Mã bài tập</th>
        <th>Tên bài tập</th>
        <th>Hạn nộp</th>
        <th>Phần trăm</th>
        <th>Mô tả</th>
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="exercise" name="exercises">
	<tr align="left">
	  <td>
            <bean:write name="exercise" property="exerciseId" />
	  </td>
	  <td>
	     <a href="javascript:ChiTiet=window.open('StudentTasksList.do?exerciseId=<bean:write name="exercise" 
                property="exerciseId"/>','ChiTiet','width=1000,height=600,resizable=yes,scrollbars=yes');ChiTiet.focus()"><bean:write name="exercise" property="name" /></a>
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
              <logic:equal name="exercise" property="isSendCorrectable"
                           value="yes" >
                    <a href="sendcorrected.jsp?subjectId=<bean:write name="exercise"
                    property="subjectId" />&exerciseId=<bean:write name="exercise"
                    property="exerciseId" />">Gửi bài chữa</a>
              </logic:equal>
          </td>
	</tr>
      </logic:iterate>
      
    </table>
  </body>
</html>