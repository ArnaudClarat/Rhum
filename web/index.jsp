<%--
  Created by IntelliJ IDEA.
  User: arnau
  Date: 22-07-20
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="models.Rhum" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  coucou<br>
  ${Rhum.getRhum(1).nom } Nom<br>
  ${Rhum.getRhum(1).prix} Prix<br>
  ${request.getAttribute("rhum")}3<br>
  </body>
</html>
