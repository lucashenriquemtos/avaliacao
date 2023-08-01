<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ação de Exame Realizado Bem-sucedida</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <h1>Ação realizada com sucesso!</h1>
    <p>Detalhes do exame realizado:</p>
    <table class="table table-bordered">
        <tr>
            <th>Código do Exame Realizado:</th>
            <td><s:property value="exameRealizadoDTO.cdExameRealizado" /></td>
        </tr>
        <tr>
            <th>Código do Exame:</th>
            <td><s:property value="exameRealizadoDTO.cdExame" /></td>
        </tr>
        <tr>
            <th>Nome do Exame:</th>
            <td><s:property value="exameRealizadoDTO.nmExame" /></td>
        </tr>
        <tr>
            <th>Resultado:</th>
            <td><s:property value="exameRealizadoDTO.resultado" /></td>
        </tr>

    </table>
</div>
</body>
</html>
