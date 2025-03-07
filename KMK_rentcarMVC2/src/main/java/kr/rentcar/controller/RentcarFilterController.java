package kr.rentcar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.rentcar.model.Rentcar;
import kr.rentcar.model.RentcarDAO;

public class RentcarFilterController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RentcarFilterController");
		HashMap<String, String> parameter = new HashMap<String, String>();

		String company = request.getParameter("company");
		company = company.equals("null") ? null : company;
		String category = request.getParameter("category");
		category = category.equals("null") ? null : category;
		System.out.println("company = " + company);
		System.out.println("category = " + category);

		parameter.put("company", company);
		parameter.put("category", category);

		ArrayList<Rentcar> list = RentcarDAO.getInstance().getRentcarListByCompanyCategory(parameter);
		System.out.println(list);

        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String imgTag = "";
        for(Rentcar rentcar : list) {
        	imgTag += String.format("<img class='rentcarImg' src='/RentcarImg/%s' data-value='%s'>"
        			, rentcar.getImg() ,rentcar.getNum());
        }
        response.getWriter().print(imgTag);
		return null;
	}

}
