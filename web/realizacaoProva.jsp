<%-- 
    Document   : realizacaoProva
    Created on : Sep 13, 2016, 11:13:57 AM
    Author     : andre
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Provas | Realizar</title>
        <link href="assets/libs/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/libs/bootstrap/dist/css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="assets/css/app.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="header.jsp" %>
                <div class="col-md-10 col-md-offset-1">
                    <div class="content font-normal jumbotron">
                        <h4>${prova.nome}</h4>
                        <hr />
                        <form action="prova?acao=enviarRealizacao" method="post">
                            <c:set var="letras" value="${['a', 'b', 'c', 'd', 'e']}" scope="application"></c:set>
                            <c:forEach items="${prova.questoes}" var="questao" varStatus="questaoLoop">
                                <div class="panel-group">
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <p>
                                                <strong>Questão #${questaoLoop.index + 1}: </strong>
                                                ${questao.enunciado}
                                            </p>
                                            <c:forEach items="${questao.alternativas}" var="alternativa" varStatus="alternativaLoop">
                                                <div class="radio">
                                                    <label>
                                                        <input type="radio" name="respostaQuestao${questaoLoop.index + 1}" value="${alternativaLoop.index}" />
                                                        ${letras[alternativaLoop.index]}) ${alternativa}
                                                    </label>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <hr />
                            <div class="col-md-3 col-md-offset-3">
                                <a href="/Provas" class="btn btn-danger btn-lg btn-block">Cancelar</a>
                            </div>
                            <div class="col-md-3">
                                <button type="submit" class="btn btn-success btn-lg btn-block">Enviar</button>
                            </div>
                            <div class="clearfix"></div>
                            <input type="hidden" name="idProva" value="${prova.id}" />
                        </form>
                    </div>
                </div>
                <%@include file="footer.jsp" %>
            </div>
        </div>
        <script src="assets/libs/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="assets/libs/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
