<%-- 
    Document   : listaProvas
    Created on : Sep 12, 2016, 4:43:08 PM
    Author     : andre
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Provas | Listagem</title>
        <link href="assets/libs/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/libs/bootstrap/dist/css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="assets/css/app.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="header.jsp" %>
                <div class="col-md-10 col-md-offset-1">
                    <div class="content jumbotron">
                        <h3>Listagem de provas</h3>
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>Código</th>
                                    <th>Nome</th>
                                    <th>Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${provas}" var="prova">
                                    <tr>
                                        <td>${prova.id}</td>
                                        <td>${prova.nome}</td>
                                        <td>
                                            <a href="prova?acao=realizar&id=${prova.id}" class="btn btn-primary btn-sm">Realizar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <%@include file="footer.jsp" %>
            </div>
        </div>
        <script src="assets/libs/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="assets/libs/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
