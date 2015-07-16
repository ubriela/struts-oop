<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>

<html>
  <head>
      <META http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <title>Ma mon hoc: </title>
    <link rel = "stylesheet" href = "styles.css" 
      type = "text/css" />
  </head>

  <body>
      <bean:parameter id="subjId" name="subjectId" value=""/>
      <form name="exerciseForm" method="post" action="/StrutsOOP/SendExerciseFCK.do" accept-charset="UTF-8" enctype="multipart/form-data">
      <table width="800" border="0">
        <tr>
          <td>Mã môn học: <nested:text property="subjectId"  value="<%=subjId%>"/></td>
        </tr>
       <tr>
          <td>Tên bài tập: <input type="text" name="name" value="Toán rời rạc"></td>
        </tr>
        <tr>

          <td>Thời hạn nộp (yyyy-mm-dd): <input type="text" name="deadline" value=""></td>
        </tr>
        <tr>
          <td>Phần trăm: <input type="text" name="percent" value="0"></td>
        </tr>
        <tr>
          <td>Mô tả: <textarea name="description"></textarea></td>
        </tr>
        <tr>
          <td>
             <FCK:editor instanceName="contentStr">
                <jsp:attribute name="value">This is some <strong>sample text</strong>.
                    You are using <a href="http://www.fckeditor.net">FCKeditor</a>.
                 </jsp:attribute>
                <jsp:body>
                        <FCK:config SkinPath="skins/office2003/"/>
                </jsp:body>
            </FCK:editor>
         </td>
        </tr>
        <tr>
          <td>hay File: <input type="file" name="theFile" value=""> </td>
        </tr>
     <tr>
      <td>
        <input type="submit" value="Giao bài">
      </td>
    </tr>
      </table>
    </form> 
  </body>
</html>