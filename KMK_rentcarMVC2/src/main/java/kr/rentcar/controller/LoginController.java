package kr.rentcar.controller;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.rentcar.model.UserDAO;

public class LoginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		if(userId == null) {
			return "login";
		}
		String pwd = request.getParameter("pwd");
		HashMap<String, String> parameter = new HashMap<String, String>();
		parameter.put("userId", userId);
		parameter.put("pwd", pwd);
		int num = UserDAO.getInstance().checkLogin(parameter);
		if(num == -1) {
			System.out.println("로그인 실패");
			return "login";
		}
		HttpSession session = request.getSession();
		session.setAttribute("log",num);
		String ctx = request.getContextPath();
		return "redirect:" + ctx +"/index.jsp";
	}

}
