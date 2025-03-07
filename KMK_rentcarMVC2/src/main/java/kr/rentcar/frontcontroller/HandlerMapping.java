package kr.rentcar.frontcontroller;

import java.util.HashMap;

import kr.rentcar.controller.Controller;
import kr.rentcar.controller.LoginController;
import kr.rentcar.controller.LogoutController;
import kr.rentcar.controller.RentcarContentController;
import kr.rentcar.controller.RentcarFilterController;
import kr.rentcar.controller.RentcarReserveController;
import kr.rentcar.controller.SignUpController;
import kr.rentcar.controller.indexController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/index.do", new indexController());
		mappings.put("/rentcarReserve.do", new RentcarReserveController());
		mappings.put("/rentcarFilter.do", new RentcarFilterController());
		mappings.put("/rentcarContent.do", new RentcarContentController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/signUp.do", new SignUpController());

	}

	public Controller getController(String key) {
		System.out.println(key);
		return mappings.get(key);
	}
}
