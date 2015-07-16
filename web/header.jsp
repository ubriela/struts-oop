<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
    
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<bean:define id="name" name="userbean" property="name"/>
Xin chào, <%= name%> [<logic:equal name="userbean" property="usertype"
                           value="1" >
                    <a href="StudentSubjectsList.do">home</a>, <a href="Logout.do">logout</a>]
                </logic:equal>
                <logic:equal name="userbean" property="usertype"
                           value="2" >
                    <a href="TeacherSubjectsList.do">home</a>, <a href="Logout.do">logout</a>]
                </logic:equal>
<hr width="80%" noshade="true">