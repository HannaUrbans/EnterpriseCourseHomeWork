package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;


import logic.LogicStubForAuthorization;
import logic.LogicStubForRegistration;

public class Controller extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private final LogicStubForAuthorization logicForAuthorization = new LogicStubForAuthorization();
	private final LogicStubForRegistration logicForRegistration = new LogicStubForRegistration();

	public Controller() {
		super();
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doRequest(request, response);
	}
	
	private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String command = request.getParameter("command");
	RequestDispatcher dispatcher = null;
	
	switch (command) {
	case "goToAuthenticationPage":
		dispatcher = request.getRequestDispatcher("WEB-INF/jsp/authPage.jsp");
		dispatcher.forward(request, response);
		break;

	case "login":
		String emailAuthorizedUser = request.getParameter("email");
		String passwordAuthorizedUser = request.getParameter("password");
		if(logicForAuthorization.checkAuth(emailAuthorizedUser, passwordAuthorizedUser)) {
			dispatcher = request.getRequestDispatcher("WEB-INF/jsp/startPage.jsp");
			dispatcher.forward(request, response);
		}else {
			dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		break;

	case "goToRegistrationPage":
		dispatcher = request.getRequestDispatcher("WEB-INF/jsp/regPage.jsp");
		dispatcher.forward(request, response);
		break;
		
	case "register":
		String nameForRegistration = request.getParameter("name");
		String emailForRegistration = request.getParameter("email");
		String passwordForRegistration = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		if(!passwordForRegistration.equals(confirmPassword)) {
			request.setAttribute("registrationError", "Пароли не совпадают.");
			  dispatcher = request.getRequestDispatcher("WEB-INF/jsp/regPage.jsp");
		      dispatcher.forward(request, response);
		      break;
		}
		if(logicForRegistration.checkAuth(nameForRegistration, emailForRegistration, passwordForRegistration)) {
			dispatcher = request.getRequestDispatcher("WEB-INF/jsp/authPage.jsp");
			dispatcher.forward(request, response);
		}else {
			dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		break;
		
	case "stub":
		dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stub.jsp");
		dispatcher.forward(request, response);
		break;
	}
	}
}