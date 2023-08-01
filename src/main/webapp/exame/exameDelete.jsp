<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Deletar Exame</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <h1>Deletar Exame</h1>
    <s:form action="exameAction!delete" cssClass="form-horizontal">
        <div class="form-group">
            <s:textfield name="exameDTO.cdExame" label="Código do Exame" cssClass="form-control" readonly="true" />
        </div>
        <div class="form-group">
            <s:textfield name="exameDTO.nmExame" label="Nome do Exame" cssClass="form-control" readonly="true" />
        </div>
        <div class="form-group">
            <s:submit value="Confirmar Deleção" cssClass="btn btn-danger" />
        </div>
    </s:form>
</div>
</body>
</html>
