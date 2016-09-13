<%-- 
    Document   : exibeCorrecao.jsp
    Created on : Sep 13, 2016, 2:37:41 PM
    Author     : andre
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Provas | Correção</title>
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
                        <h3>${correcao.prova.nome}</h3>
                        <div class="col-md-4 col-md-offset-4 text-center">
                            <h3>Nota</h3>
                            <span class="valorNota text-primary">
                                ${correcao.nota}
                            </span>
                        </div>
                        <div class="clearfix"></div>
                        <hr />
                        <c:set var="letras" value="${['a', 'b', 'c', 'd', 'e']}" scope="application"></c:set>
                        <c:forEach items="${correcao.prova.questoes}" var="questao" varStatus="questaoLoop">
                            <div class="panel-group">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <p>
                                            <c:set var="errou" value="${questao.alternativaCorreta != correcao.indicesRespostas.get(questaoLoop.index)}"></c:set> 
                                            <strong>Questão #${questaoLoop.index + 1}: </strong>
                                            ${questao.enunciado}
                                            <c:if test="${errou}">
                                                <span class="glyphicon glyphicon-remove text-danger"></span>
                                                <span class="label label-danger">+0</span>
                                            </c:if>
                                            <c:if test="${not errou}">
                                                <span class="glyphicon glyphicon-ok text-success"></span>
                                                <span class="label label-success">+2</span>
                                            </c:if>
                                        </p>
                                        <div class="list-group">
                                            <c:forEach items="${questao.alternativas}" var="alternativa" varStatus="alternativaLoop">
                                                <c:if test="${alternativaLoop.index == questao.alternativaCorreta}">
                                                    <c:set var="classeAlternativaCorreta" value="list-group-item-success"></c:set>
                                                </c:if>
                                                <c:if test="${errou and alternativaLoop.index == correcao.indicesRespostas.get(questaoLoop.index)}">
                                                    <c:set var="classeRespostaErrada" value="list-group-item-danger"></c:set>
                                                </c:if>
                                                <div class="list-group-item ${classeAlternativaCorreta} ${classeRespostaErrada}">
                                                    <c:set var="classeAlternativaCorreta" value="" />
                                                    <c:set var="classeRespostaErrada" value="" />
                                                    ${letras[alternativaLoop.index]}) ${alternativa}
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <hr />
                        <div class="col-md-4 col-md-offset-4">
                            <a href="/Provas" class="btn btn-default btn-lg btn-block">Voltar</a>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <%@include file="footer.jsp" %>
            </div>
        </div>
        <script src="assets/libs/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="assets/libs/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>

