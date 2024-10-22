package by.urban.web_project2.controller.concrete.implementation;

import by.urban.web_project2.logic.LogicStubForAuthorization;

import java.io.IOException;

import by.urban.web_project2.controller.concrete.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoAuth implements Command{
	private final  LogicStubForAuthorization logicForAuthorization = new  LogicStubForAuthorization();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(logicForAuthorization.checkAuth(email, password)) {
			request.setAttribute("invitationMessage", "Приветствую!");
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/startPage.jsp");
		dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("authError", "Неправильный email или пароль!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
			dispatcher.forward(request, response);
		}
	}
	}
