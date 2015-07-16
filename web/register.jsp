<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

<html>
  <head>
      <META http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <title>Register</title>
    <link rel = "stylesheet" href = "styles.css" 
      type = "text/css" />
  </head>

  <body>
      <html:form  action="/Register">
      <table width="500" border="0">
        <tr>
          <td>User name: <html:text property="username"/></td>
        </tr>
        <tr>
          <td>Password: <html:password property="password"/></td>
        </tr>
        <tr>
          <td>Họ và tên: <html:text property="name"/></td>
        </tr>
        <tr>
          <td>Email: <html:text property="email" /></td>
        </tr>
        <tr>
          <td>Số điện thoại: <html:text property="phone"/></td>
        </tr>
        <tr>
          <td>Địa chỉ: <html:text property="address" /> </td>
        </tr>
        <tr>
          <td>Mã chứng thực(giảng viên): <html:text property="autherCode" /> </td>
        </tr>
         <tr>
          <td>
            <html:submit>Đăng ký</html:submit>
          </td>
        </tr>
      </table>
    </html:form> 
  </body>
</html>