<%--
  Created by IntelliJ IDEA.
  User: arnau
  Date: 22-07-20
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="models.Rhum" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <c:forEach var="id" begin="1" end="8" step="1">
    Nom : ${Rhum.getRhum(id).nom }<br>
    Prix : ${Rhum.getRhum(id).prix} €<br>
    Détails : ${Rhum.getRhum(id).details}<br>
    Marque : ${Rhum.getRhum(id).marque}<br>
    Origine : ${Rhum.getRhum(id).origine}<br>
  </c:forEach>
  </body>
</html>
