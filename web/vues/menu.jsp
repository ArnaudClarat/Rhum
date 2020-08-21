<%--
  Created by IntelliJ IDEA.
  User: arnau
  Date: 22-07-20
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<table>
    <c:forEach var="rhum" items="${rhums}" >
        <tr>
            <td>${rhum.getMarque()} ${rhum.getNom()}</td>
            <td>${rhum.getPrix()}€</td>
            <td>${rhum.getDetails()}</td>
            <td>${rhum.getOrigine()}</td>
        </tr>
    </c:forEach>
    <%--
    <c:forEach var="id" begin="1" end="8" step="1">
      <tr>
        <td>${Rhum.getRhum(id).marque} ${Rhum.getRhum(id).nom }</td>
        <td>Détails : ${Rhum.getRhum(id).details}</td>
        <td>Prix : ${Rhum.getRhum(id).prix} €</td>
        <td>Origine : ${Rhum.getRhum(id).origine}</td>
      </tr>
    </c:forEach>
    --%>
</table>
</body>
</html>
