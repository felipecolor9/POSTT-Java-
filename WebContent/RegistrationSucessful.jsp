<%@ page import="br.com.felipe.projeto.controller.UserController"%>

<%
	UserController uc = new UserController();
	String userCompNameReg = request.getParameter("userCompNameReg");
	String userNameReg = request.getParameter("userNameReg");
	String userPassReg = request.getParameter("userPassReg");
	String confirmUserPassReg = request.getParameter("confirmUserPassReg");
	
	if (uc.checkRegister(userCompNameReg, userNameReg, userPassReg, confirmUserPassReg)) {
		
		session.setAttribute("regFb", "Registrado com sucesso!");
		response.sendRedirect("Login.jsp");
	}
%>