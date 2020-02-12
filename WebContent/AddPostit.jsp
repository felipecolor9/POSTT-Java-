<%@ page import="br.com.felipe.projeto.controller.PostitController"%>
	
<%
		PostitController pc = new PostitController();
		String postitName = request.getParameter("postitName");
		String postitDescription = request.getParameter("postitDescription");
		int postitUserId = (Integer) session.getAttribute("userId");
		
		pc.addPostit(postitName, postitDescription, postitUserId);

		response.sendRedirect("Userboard.jsp");
%>