package kr.rentcar.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.rentcar.frontcontroller.ViewResolver;
import kr.rentcar.model.Rentcar;
import kr.rentcar.model.RentcarDAO;

public class indexController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Rentcar> list = RentcarDAO.getInstance().getRentcarList();
		HttpSession session = request.getSession();
		session.setAttribute("rentcarList", list);
		String ctx = request.getContextPath();
		return "redirect:" + ctx +"/index.jsp";
	}

}
