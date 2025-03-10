package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RentcarOptionController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String img = request.getParameter("img");
		String num = request.getParameter("num");
		request.setAttribute("img", img);
		request.setAttribute("num", num);
		
		return "rentOption";
	}

}
