<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
    <link rel = "stylesheet" href = "styles.css" 
      type = "text/css" />
</head>
<body>

<tiles:insert attribute="header"/>


<tiles:insert attribute="body"/>


<tiles:insert attribute="footer"/>

</body>
</html>