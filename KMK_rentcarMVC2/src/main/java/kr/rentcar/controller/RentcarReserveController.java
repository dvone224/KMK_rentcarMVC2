package kr.rentcar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.model.RentcarDAO;

public class RentcarReserveController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RentcarDAO dao = RentcarDAO.getInstance();
		ArrayList<String> companies = dao.getGroupByRentcarList("company");
		ArrayList<String> categories = dao.getGroupByRentcarList("category");
		companies.sort(Comparator.naturalOrder());
		categories.sort(Comparator.naturalOrder());
		for (int i = 0; i < categories.size(); i++) {
			switch (categories.get(i)) {
			case "1":
				categories.set(i, "소형");
				break;
			case "2":
				categories.set(i, "중형");
				break;
			case "3":
				categories.set(i, "대형");
				break;
			}
		}
		request.setAttribute("companies", companies);
		request.setAttribute("categories", categories);
		return "carReserve";
	}

}
