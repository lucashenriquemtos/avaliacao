<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Funcionário</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container mt-4">
    <h1>Editar Funcionário</h1>
    <s:form action="update" method="post">
        <div class="form-group">
            <label for="cdFuncionario">Código:</label>
            <s:textfield name="funcionarioDTO.cdFuncionario" cssClass="form-control" />
        </div>
        <div class="form-group">
            <label for="nmFuncionario">Nome:</label>
            <s:textfield name="funcionarioDTO.nmFuncionario" cssClass="form-control" />
        </div>

        <button type="submit" class="btn btn-primary">Salvar</button>
    </s:form>
</div>
</body>
</html>
