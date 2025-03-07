package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.model.UserDAO;

public class VaildIdAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");
		boolean isValidId = UserDAO.getInstance().isValidId(userId);
		if (isValidId) {
			response.getWriter().print(userId);
		} else {
			response.getWriter().print("");
		}

		return null;
	}

}
