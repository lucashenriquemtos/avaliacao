<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Exame de Entrada</title>
    <!-- Adicionando o CSS do Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <h1>Formulário de Exame</h1>
    <s:form action="exameAction!input" cssClass="form-horizontal">
        <div class="form-group">
            <s:textfield name="exameDTO.cdExame" label="Código do Exame" cssClass="form-control" />
        </div>
        <div class="form-group">
            <s:textfield name="exameDTO.nmExame" label="Nome do Exame" cssClass="form-control" />
        </div>
        <div class="form-group">
            <s:checkbox name="exameDTO.icAtivo" label="Exame Ativo" cssClass="form-control" />
        </div>
        <div class="form-group">
            <s:textarea name="exameDTO.dsDetalheExame" label="Detalhe do Exame" cssClass="form-control" />
        </div>
        <div class="form-group">
            <s:textarea name="exameDTO.dsDetalheExame1" label="Detalhe do Exame 1" cssClass="form-control" />
        </div>
        <div class="form-group">
            <s:submit value="Submit" cssClass="btn btn-primary" />
        </div>
    </s:form>
</div>
</body>
</html>
