<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Deletar Usuário</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8 offset-md-2">
            <h2 class="mt-5">Deletar Usuário</h2>
            <s:form action="usuarioAction" cssClass="form">
                <s:hidden name="usuarioDTO.nmLogin" />
                <p>Você tem certeza que deseja deletar o usuário <s:property value="usuarioDTO.nmLogin"/>?</p>
                <s:submit value="Deletar Usuário" cssClass="btn btn-danger" />
            </s:form>
        </div>
    </div>
</div>
</body>
</html>
