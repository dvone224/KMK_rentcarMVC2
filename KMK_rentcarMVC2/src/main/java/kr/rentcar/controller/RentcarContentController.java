package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.model.Rentcar;
import kr.rentcar.model.RentcarDAO;

public class RentcarContentController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("no"));
		Rentcar rentcar = RentcarDAO.getInstance().getARentcarByNo(num);
		request.setAttribute("rentcar", rentcar);
		
		return "carContent";
	}

}
