<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.3.2/css/bootstrap.min.css">
    <meta charset="utf-8">
    <title>Employees List</title>
</head>
<body>
<header>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg bg-body">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarExample01">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item active">
                        <h1>Employees List</h1>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Navbar -->
</header>
<main>
    <table class="table" >
        <thead>
        <tr>
            <th scope="col">Employee Id</th><th scope="col">Employee Name</th><th scope="col">Employee FirstName</th><th scope="col">Departement</th><th scope="col"> Poste </th><th scope="col">Date Embauche</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employesJsp}" var="employe">
            <tr>
                <td>${employe.employeId}</td>
                <td>${employe.nom}</td>
                <td>${employe.prenom}</td>
                <td>${employe.departement}</td>
                <td>${employe.poste}</td>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${employe.date_embauche}" /></td>
                <td><a onclick="return confirm('Are you sure to delete this employe ?')"
                    href="deleteEmploye?id=${employe.employeId}"
                >Delete</a></td>

            <td>
            <a href="editEmploye?id=${employe.employeId}"> Edit</a>
            </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<footer class="text-center text-lg-start bg-body-tertiary text-muted">
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
        <a class="text-reset fw-bold" href="employeList">Employes List</a>
    </div>
</footer>
</body>
</html>
