<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des types</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp"%>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">Liste des types</div>
            <div class="card-body">
                <table class="table table-striped">
                    <tr>
                        <th>ID</th>
                        <th>Type</th>
                        <th>Date Création</th>
                        <th>Suppression</th>
                        <th>Edition</th>
                    </tr>
                    <c:forEach items="${model.types}" var="type">
                        <tr>
                            <td>${type.idT }</td>
                            <td>${type.nomT }</td>
                            <td><fmt:formatDate pattern="dd/MM/yyyy"
                                    value="${type.dateT}" /></td>
                            <td><a onclick="return confirm('Êtes-vous sûr ?')"
                                href="supprimerType?id=${type.idT}">Supprimer</a></td>
                            <td><a href="editerType?id=${type.idT}">Modifier</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
