package kr.rentcar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.model.Rentcar;
import kr.rentcar.model.RentcarDAO;
import kr.rentcar.model.Reservation;
import kr.rentcar.model.ReservationDAO;

public class AddReservationController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String userId = request.getParameter("userId");
		int qty = 1;
		int dDay = Integer.parseInt(request.getParameter("dDay"));
		String rDay = request.getParameter("rDay");
		int useIn = Integer.parseInt(request.getParameter("useIn"));
		int useWifi = Integer.parseInt(request.getParameter("useWifi"));
		int useNavi = Integer.parseInt(request.getParameter("useNavi"));
		int useSeat = Integer.parseInt(request.getParameter("useSeat"));
		Reservation reservation = new Reservation(num, userId, qty, dDay, rDay, useIn, useWifi, useNavi, useSeat);
		System.out.println("reservation = " + reservation);
		int cnt = ReservationDAO.getInstance().insertReservation(reservation);
		Rentcar rentcar = RentcarDAO.getInstance().getARentcarByNum(num);
		
		System.out.println(rentcar);
		rentcar.settotal_qty(rentcar.gettotal_qty() - qty);
		cnt = RentcarDAO.getInstance().updateTotalQty(rentcar);
		int carPrice = rentcar.getprice() * dDay;
		int optionPrice = (useIn + useWifi + useSeat) * 10000;
		request.setAttribute("carPrice", carPrice);
		request.setAttribute("optionPrice", optionPrice);
		return "rentResult";
	}

}
