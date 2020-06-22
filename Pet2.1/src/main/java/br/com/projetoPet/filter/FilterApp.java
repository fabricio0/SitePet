package br.com.projetoPet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.projetoPet.util.Usuario;

@WebFilter(urlPatterns = "/resources/html/*")
public class FilterApp implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		EntityManager entityManager = EntityPersistence.CriaEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();


		// TODO Auto-generated method stub
//		EntityManager entityManager =  EntityPersistence.CriaEntityManager();
//		entityManager.close();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String url = req.getServletPath();
		request.getParameter("usuario");
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
//		System.out.println("url da requisição");
//		System.out.println(url);
		if (!url.equalsIgnoreCase("/resources/index.xhtml") && usuarioLogado == null) {
//			System.out.println("oks");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/index.xhtml");
			dispatcher.forward(request, response);
		} else {
//			System.out.println(session.getAttributeNames());
//			System.out.println("ois");
				chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
