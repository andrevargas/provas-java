<%-- 
    Document   : cadastroProva
    Created on : Sep 13, 2016, 8:21:41 AM
    Author     : andre
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Provas | Cadastro</title>
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
                        <form method="post" action="prova?acao=salvarCadastro">
                            <h3>Cabeçalho</h3> 
                            <div class="form-group">
                                <label>Nome da prova</label>
                                <input class="form-control" type="text" name="nome" required />
                            </div>
                            <hr />
                            <h3>Questões</h3>
                            <c:set var="letras" value="${['a', 'b', 'c', 'd', 'e']}" scope="application"></c:set>
                            <c:forEach begin="1" end="1" varStatus="questaoLoop">
                                <div class="well well-lg">
                                    <h4>Questão #${questaoLoop.index}</h4>
                                    <div class="form-group row">
                                        <label class="col-md-2 col-form-label">Enunciado</label>
                                        <div class="col-md-10">
                                            <textarea class="form-control" name="enunciadoQuestao${questaoLoop.index}" required ></textarea>
                                        </div>
                                    </div> 
                                        <c:forEach items="${letras}" var="letra" varStatus="alternativaLoop">
                                        <div class="form-group row">
                                            <label class="col-md-2 col-form-label">${letra})</label>
                                            <div class="col-md-10">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" name="alternativa${alternativaLoop.index + 1}Questao${questaoLoop.index}" required />
                                                    <span class="input-group-addon">
                                                        <input type="radio" value="${alternativaLoop.index}" name="alternativaCorretaQuestao${questaoLoop.index}" required />
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </c:forEach>
                            <hr />
                            <div class="col-md-3 col-md-offset-3">
                                <a href="/Provas" class="btn btn-danger btn-lg btn-block">Cancelar</a>
                            </div>
                            <div class="col-md-3">
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Salvar</button>
                            </div>
                            <div class="clearfix"></div>
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