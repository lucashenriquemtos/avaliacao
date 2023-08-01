<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ação de Exame Bem-sucedida</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<h1>Ação realizada com sucesso!</h1>
<p>Detalhes do exame:</p>
<table>
    <tr>
        <td>Nome do Exame:</td>
        <td><s:property value="exameDTO.nmExame" /></td>
    </tr>
</table>
</body>
</html>
