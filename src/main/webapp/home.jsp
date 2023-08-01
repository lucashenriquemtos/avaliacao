<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.lhmatos.dto.UsuarioDTO" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Página Inicial</title>

</head>
<body>
<nav class="navbar navbar-light bg-light">
        <span class="navbar-text">
            Bem-vindo,
            <%
                HttpSession httpsession = request.getSession();
                UsuarioDTO usuarioLogado = (UsuarioDTO) session.getAttribute("usuarioLogado");
                if (usuarioLogado != null) {
                    System.out.println(usuarioLogado.getNmLogin());
                }
            %>
        </span>
</nav>
</body>
</html>
