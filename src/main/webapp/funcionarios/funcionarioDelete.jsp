<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Excluir Funcionário</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container mt-4">
    <h1>Excluir Funcionário</h1>
    <p>Deseja realmente excluir o funcionário de código <s:property value="funcionarioDTO.cdFuncionario" />?</p>
    <s:form action="delete" method="post">
        <button type="submit" class="btn btn-danger">Sim, excluir</button>
        <a href="list" class="btn btn-secondary">Cancelar</a>
    </s:form>
</div>
</body>
</html>
