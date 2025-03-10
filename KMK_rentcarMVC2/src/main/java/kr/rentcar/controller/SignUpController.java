package kr.rentcar.controller;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.model.User;
import kr.rentcar.model.UserDAO;

public class SignUpController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");
		if(userId == null) {
			return "signUp";
		}
		
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		User user = new User(name, userId, pwd, email, phone);
		int cnt = UserDAO.getInstance().insertUser(user);
		String ctx = request.getContextPath();
		
		return "redirect:" + ctx +"/index.jsp";
	}

}
