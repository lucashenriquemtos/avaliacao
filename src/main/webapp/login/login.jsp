<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2>Login</h2>
            <s:form action="login" method="post">
                <div class="form-group">
                    <label for="login">Login</label>
                    <s:textfield class="form-control" id="login" name="login" required="true" />
                </div>
                <div class="form-group">
                    <label for="password">Senha</label>
                    <s:password class="form-control" id="password" name="password" required="true" />
                </div>
                <s:submit class="btn btn-primary" value="Entrar" />
            </s:form>
            <s:actionerror/>
        </div>
    </div>
</div>
</body>
</html>
