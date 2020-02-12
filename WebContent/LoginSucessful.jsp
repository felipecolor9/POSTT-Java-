<%@ page import="br.com.felipe.projeto.controller.UserController"%>
<%
	UserController uc = new UserController();
	String userNameLogin = request.getParameter("userNameLogin");
	String userPassLogin = request.getParameter("userPassLogin");

	if (uc.checkLogin(userNameLogin, userPassLogin)) {
		session.setAttribute("username", userNameLogin);
		session.setAttribute("userId", uc.getActualUserId(userNameLogin));
		response.sendRedirect("Userboard.jsp");
	} else {
		session.setAttribute("msg", "Usuario e/ou senha invalidos. Favor, tentar novamente.");
		response.sendRedirect("Login.jsp");
	}
%>
