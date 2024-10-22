package by.urban.web_project2.controller.concrete.implementation;
import by.urban.web_project2.logic.LogicStubForRegistration;
import by.urban.web_project2.logic.PasswordCheck;

import java.io.IOException;

import by.urban.web_project2.controller.concrete.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoRegistration implements Command{
	private final LogicStubForRegistration logicForRegistration = new  LogicStubForRegistration();
	private final PasswordCheck passwordCheck = new  PasswordCheck();
	RequestDispatcher dispatcher = null;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameForRegistration = request.getParameter("name");
		String emailForRegistration = request.getParameter("email");
		String passwordForRegistration = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		 if (!passwordCheck.check(request, passwordForRegistration, confirmPassword)) {
	            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/regPage.jsp");
	            dispatcher.forward(request, response);
	            return; 
	        }
		
		if(logicForRegistration.checkAuth(nameForRegistration, emailForRegistration, passwordForRegistration)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/authPage.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
	}
