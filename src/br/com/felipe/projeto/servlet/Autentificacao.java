package br.com.felipe.projeto.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipe.projeto.controller.UserController;

@WebServlet({ "/Autentificacao", "/aut" })
public class Autentificacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Autentificacao() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserController uc = new UserController();

		String userNameLogin = request.getParameter("userNameLogin");
		String userPassLogin = request.getParameter("userPassLogin");
	
	if (uc.checkUser(userNameLogin, userPassLogin)) {
			response.sendRedirect("Userboard.jsp");
		} else {
			response.sendRedirect("InvalidLogin.jsp");
		}
	}
}
