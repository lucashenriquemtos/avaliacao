<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edição de Exame Realizado</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <h1>Edição de Exame Realizado</h1>

    <s:form action="updateExameRealizado" method="post">
        <div class="form-group">
            <label for="cdExameRealizado">Código do Exame Realizado:</label>
            <s:textfield name="exameRealizadoDTO.cdExameRealizado" value="%{#exameRealizadoDTO.cdExameRealizado}" cssClass="form-control" disabled="true" />
        </div>
        <div class="form-group">
            <label for="cdExame">Código do Exame:</label>
            <s:textfield name="exameRealizadoDTO.cdExame" value="%{#exameRealizadoDTO.cdExame}" cssClass="form-control" />
        </div>
        <div class="form-group">
            <label for="nmExame">Nome do Exame:</label>
            <s:textfield name="exameRealizadoDTO.nmExame" value="%{#exameRealizadoDTO.nmExame}" cssClass="form-control" />
        </div>
        <div class="form-group">
            <label for="resultado">Resultado:</label>
            <s:textfield name="exameRealizadoDTO.resultado" value="%{#exameRealizadoDTO.resultado}" cssClass="form-control" />
        </div>

        <button type="submit" class="btn btn-primary">Salvar</button>
    </s:form>
</div>
</body>
</html>
