package by.urban.web_project2.logic;

import jakarta.servlet.http.HttpServletRequest;

public class PasswordCheck {
public boolean check(HttpServletRequest request, String value1, String value2) {
	if(!value1.equals(value2)) {
		request.setAttribute("registrationError", "Пароли не совпадают.");
	    return false;
	}
	return true;
}
}
