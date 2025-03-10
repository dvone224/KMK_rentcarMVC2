package kr.rentcar.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		String pwd = request.getParameter("pwd");
		HashMap<String, String> parameter = new HashMap<String, String>();
		parameter.put("userId", userId);
		parameter.put("pwd", pwd);
		userId = UserDAO.getInstance().checkLogin(parameter);
		
		if(userId == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 실패'); history.back();</script>");
			writer.close();
			return null;
		}
		HttpSession session = request.getSession();
		session.setAttribute("log",userId);
		String ctx = request.getContextPath();
		return "redirect:" + ctx +"/index.jsp";
	}

}
