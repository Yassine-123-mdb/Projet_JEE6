<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Modification des Smartphones</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="header.jsp" %>
<p></p>
<div class="container">
    <div class="card">
        <div class="card-header">
            Modification des Smartphones
        </div>
        <div class="card-body">
            <form action="update.do" method="post">
                <div hidden class="form-group" >
                    <label class="control-label">ID Smartphone :</label>
                    <input type="text" name="id" class="form-control" value="${smartPhone.idSmartPhone}"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Marque :</label>
                    <input type="text" name="marque" class="form-control" value="${smartPhone.marque}"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Couleur :</label>
                    <input type="text" name="couleur" class="form-control" value="${smartPhone.couleur}"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Prix :</label>
                    <input type="text" name="prix" class="form-control" value="${smartPhone.prix}"/>
                </div>
                <div class="form-group">
                    <label class="control-label">RAM :</label>
                    <input type="text" name="ram" class="form-control" value="${smartPhone.ram}"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Stockage :</label>
                    <input type="text" name="stockage" class="form-control" value="${smartPhone.stockage}"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Type :</label>
                    <select name="type" class="form-control">
                        <option value="${smartPhone.type.idT}" selected>${smartPhone.type.nomT}</option>
                        <c:forEach items="${typeModel.types}" var="type">
                            <c:if test="${type.idT != smartPhone.type.idT}">
                                <option value="${type.idT}">${type.nomT}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">Modifier</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
