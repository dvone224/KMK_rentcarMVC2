package kr.rentcar.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import kr.rentcar.util.SqlSessionUtil;

public class ReservationDAO {
	private static ReservationDAO instance;
	private ReservationDAO() {
		
	}
	
	public static ReservationDAO getInstance() {
		if(instance == null) instance = new ReservationDAO();
		return instance;
	}
	
	public int insertReservation(Reservation reservation) {
		int cnt = 0;
		try(SqlSession session = SqlSessionUtil.getSession().openSession()) {
			cnt = session.insert("insertReservation", reservation);
			session.commit();
		}catch (Exception e) {
			System.out.println("insertReservation() 에러");
			e.printStackTrace();
		}
		return cnt;
	}
	
	public ArrayList<HashMap<String, Object>> getReserveList(String userid) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try(SqlSession session = SqlSessionUtil.getSession().openSession()) {
			list =  (ArrayList) session.selectList("getReserveList", userid);
		}catch (Exception e) {
			System.out.println("getReserveList() 에러");
			e.printStackTrace();
		}
		return list;
	}
}
