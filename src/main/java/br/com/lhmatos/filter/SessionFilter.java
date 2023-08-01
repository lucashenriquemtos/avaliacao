package br.com.lhmatos.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "SessionFilter", urlPatterns = {"/*"})
public class SessionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Código de inicialização, se necessário
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);


		if (session == null || session.getAttribute("usuarioLogado") == null) {

			res.sendRedirect(req.getContextPath() + "/login/login.jsp");
		} else {

			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}
}