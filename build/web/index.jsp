<%-- 
    Document   : index
    Created on : Sep 12, 2016, 2:31:35 PM
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Provas</title>
        <link href="assets/libs/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/libs/bootstrap/dist/css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="assets/css/app.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%@include file="header.jsp" %>
                <div class="col-md-10 col-md-offset-1">
                    <div class="content index">
                        <a href="prova?acao=cadastrar">
                            <div class="pull-right acao cadastrar">
                                Cadastrar
                            </div>
                        </a>
                        <a href="prova?acao=realizar">
                            <div class="pull-right acao realizar">
                                Realizar
                            </div>
                        </a>
                    </div>
                </div>
                <%@include file="footer.jsp" %>
            </div>
        </div>
        <script src="assets/libs/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="assets/libs/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
