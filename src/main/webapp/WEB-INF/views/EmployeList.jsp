<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Employees List</title>
</head>
<body>
<header>
    <h1>Employees List</h1>
</header>
<main>
    <table >
        <tr>
            <th>Employee Id</th><th>Employee Name</th><th>Employee FirstName</th><th>Departement</th><th> Poste </th><th>Date Embauche</th>
        </tr>
        <c:forEach items="${employesJsp}" var="employe">
            <tr>
                <td>${employe.employeId}</td>
                <td>${employe.nom}</td>
                <td>${employe.prenom}</td>
                <td>${employe.departement}</td>
                <td>${employe.poste}</td>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${employe.date_embauche}" /></td>
            </tr>
        </c:forEach>
    </table>
</main>
<footer>
    <a href="createEmploye">Employee Creation</a>
</footer>
</body>
</html>
