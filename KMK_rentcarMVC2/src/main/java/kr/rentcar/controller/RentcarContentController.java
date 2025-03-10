package kr.rentcar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.rentcar.model.Rentcar;
import kr.rentcar.model.RentcarDAO;

public class RentcarContentController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("log") == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 후 이용해주세요'); history.back(); </script>");
			writer.close();
			return null;
		}
		int num = Integer.parseInt(request.getParameter("num"));
		Rentcar rentcar = RentcarDAO.getInstance().getARentcarByNum(num);
		request.setAttribute("rentcar", rentcar);
		
		return "carContent";
	}

}
