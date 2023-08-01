<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.lhmatos.dto.UsuarioDTO" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<nav class="navbar navbar-light bg-light">
    <span class="navbar-text">
        Bem-vindo,
        <%
            HttpSession httpsession = request.getSession();
            UsuarioDTO usuarioLogado = (UsuarioDTO) httpsession.getAttribute("usuarioLogado");
            if (usuarioLogado != null) {
                System.out.print(usuarioLogado.getNmLogin());
            }
        %>
    </span>
</nav>
