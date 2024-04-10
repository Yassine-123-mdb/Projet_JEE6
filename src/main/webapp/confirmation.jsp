<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation Ajout Smartphone</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@ include file="header.jsp" %>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">
                Confirmation Ajout Smartphone
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label class="control-label">ID :</label>
                    <input type="text" name="id" class="form-control" value="${smartphone.idProduit }"/>
                    <label class="control-label">Nom Smartphone :</label>
                    <input type="text" name="nom" class="form-control" value="${smartphone.nomProduit }"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Prix :</label>
                    <input type="text" name="prix" class="form-control" value="${smartphone.prix }"/>
                    <label class="control-label">Marque :</label>
                    <input type="text" name="marque" class="form-control" value="${smartphone.marque }"/>
                    <label class="control-label">Couleur :</label>
                    <input type="text" name="couleur" class="form-control" value="${smartphone.couleur }"/>
                    <label class="control-label">RAM :</label>
                    <input type="text" name="ram" class="form-control" value="${smartphone.ram }"/>
                    <label class="control-label">Stockage :</label>
                    <input type="text" name="stockage" class="form-control" value="${smartphone.stockage }"/>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
