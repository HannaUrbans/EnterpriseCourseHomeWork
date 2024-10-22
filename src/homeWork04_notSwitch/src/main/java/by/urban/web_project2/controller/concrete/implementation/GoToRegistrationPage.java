package by.urban.web_project2.controller.concrete.implementation;

import java.io.IOException;

import by.urban.web_project2.controller.concrete.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToRegistrationPage implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/regPage.jsp");
		dispatcher.forward(request, response);
		
	}
}
