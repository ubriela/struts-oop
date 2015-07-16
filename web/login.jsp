<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
  <head>
    <title>Login</title>
    <link rel = "stylesheet" href = "styles.css" 
      type = "text/css" />
  </head>
  <body>
     
     <html:form action="/Login">
         <table>
        <tr>
        <td align="right">UserName: <html:text property="username"/><br></td>
        </tr>
        <tr>
        <td align="right">Password: <html:password property="password"/><br></td>
        </tr>
        <tr>
        <td align="center"><html:submit value="Login" /></td>
        </tr>
        </table> 
    </html:form>
    <a href="register.jsp">Đăng ký</a>
</body>
</html>