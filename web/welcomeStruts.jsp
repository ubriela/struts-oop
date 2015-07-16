<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>

<html:html locale="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body style="background-color: white">
      <form action="/FCKDemo/Submit.do" method="post" accept-charset="UTF-8">  
         <FCK:editor instanceName="content">
    <jsp:attribute name="value">This is some <strong>sample text</strong>.
      You are using <a href="http://www.fckeditor.net">FCKeditor</a>.
    </jsp:attribute>
  </FCK:editor>
  <br />
<input type="submit" value="Submit" />
</form>

        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application" >
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        
        <h3><bean:message key="welcome.heading"/></h3>
        <p><bean:message key="welcome.message"/></p>
        
    </body>
</html:html>
