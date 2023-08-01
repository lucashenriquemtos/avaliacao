<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ação de Funcionário Bem-sucedida</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container mt-4">
    <h1>Ação realizada com sucesso!</h1>
    <p>Detalhes do funcionário:</p>
    <table class="table table-bordered">
        <tr>
            <th>Código:</th>
            <td><s:property value="funcionarioDTO.cdFuncionario" /></td>
        </tr>
        <tr>
            <th>Nome:</th>
            <td><s:property value="funcionarioDTO.nmFuncionario" /></td>
        </tr>

    </table>
</div>
</body>
</html>
