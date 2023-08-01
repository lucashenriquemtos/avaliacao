<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Exame Realizado</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <h1>Cadastro de Exame Realizado</h1>

    <s:form action="createExameRealizado" method="post">
        <div class="form-group">
            <label for="cdExame">Código do Exame:</label>
            <s:textfield name="exameRealizadoDTO.cdExame" cssClass="form-control" />
        </div>
        <div class="form-group">
            <label for="nmExame">Nome do Exame:</label>
            <s:textfield name="exameRealizadoDTO.nmExame" cssClass="form-control" />
        </div>
        <div class="form-group">
            <label for="resultado">Resultado:</label>
            <s:textfield name="exameRealizadoDTO.resultado" cssClass="form-control" />
        </div>

        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </s:form>
</div>
</body>
</html>
