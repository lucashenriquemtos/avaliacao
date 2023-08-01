<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ação de Usuário Bem-sucedida</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<h1>Ação realizada com sucesso!</h1>
<p>Detalhes do usuário:</p>
<table>
    <tr>
        <td>Nome de Usuário:</td>
        <td><s:property value="usuarioDTO.nmLogin" /></td>
    </tr>
    <tr>
        <td>Tempo de Inatividade:</td>
        <td><s:property value="usuarioDTO.qtTempoInatividade" /></td>
    </tr>
</table>
</body>
</html>
