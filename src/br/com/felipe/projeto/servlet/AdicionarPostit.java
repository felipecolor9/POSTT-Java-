package br.com.felipe.projeto.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.felipe.projeto.controller.PostitController;

@WebServlet("/AdicionarPostit")
public class AdicionarPostit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdicionarPostit() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostitController pc = new PostitController();
		String postitName = request.getParameter("postitName");
		String postitDescription = request.getParameter("postitDescription");

		if(pc.getInstance().addPostit(postitName, postitDescription)) {
			response.sendRedirect("Userboard.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
