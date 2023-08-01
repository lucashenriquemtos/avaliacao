<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Excluir Exame Realizado</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <h1>Excluir Exame Realizado</h1>
    <p>Deseja realmente excluir o exame realizado?</p>
    <s:form action="deleteExameRealizado" method="post">
        <input type="hidden" name="exameRealizadoDTO.cdExameRealizado" value="%{#exameRealizadoDTO.cdExameRealizado}" />
        <button type="submit" class="btn btn-danger">Excluir</button>
    </s:form>
    <a href="<s:url action='todosExamesRealizados'/>" class="btn btn-default">Cancelar</a>
</div>
</body>
</html>
