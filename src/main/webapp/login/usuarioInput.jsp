<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Novo Usuário</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8 offset-md-2">
            <h2 class="mt-5">Criar Novo Usuário</h2>
            <s:form action="usuarioAction" cssClass="form">
                <s:textfield name="usuarioDTO.nmLogin" label="Nome de Usuário" cssClass="form-control" />
                <s:password name="usuarioDTO.dsSenha" label="Senha" cssClass="form-control" />
                <s:textfield name="usuarioDTO.qtTempoInatividade" label="Tempo de Inatividade" cssClass="form-control" />
                <s:submit value="Criar Usuário" cssClass="btn btn-primary" />
            </s:form>
        </div>
    </div>
</div>
</body>
</html>
