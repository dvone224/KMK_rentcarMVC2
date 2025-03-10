package kr.rentcar.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import kr.rentcar.util.SqlSessionUtil;

public class RentcarDAO {

	private RentcarDAO() {
	}

	private static RentcarDAO instance;

	public static RentcarDAO getInstance() {
		if (instance == null)
			instance = new RentcarDAO();
		return instance;
	}

	public ArrayList<Rentcar> getRentcarList() {
		ArrayList<Rentcar> list = new ArrayList<Rentcar>();
		try (SqlSession session = SqlSessionUtil.getSession().openSession()) {
			list = (ArrayList) session.selectList("getRentcarList");
		} catch (Exception e) {
			System.out.println("getRentcarList() 에러");
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<String> getGroupByRentcarList(String group) {
		ArrayList<String> list = new ArrayList<String>();
		try (SqlSession session = SqlSessionUtil.getSession().openSession()) {
			list = (ArrayList) session.selectList("getGroupByRentcarList", group);
		} catch (Exception e) {
			System.out.println("getGroupByRentcarList() 에러");
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Rentcar> getRentcarListByCompanyCategory(HashMap<String, String> map) {
		ArrayList<Rentcar> list = new ArrayList<Rentcar>();
		try (SqlSession session = SqlSessionUtil.getSession().openSession()) {
			list = (ArrayList) session.selectList("getRentcarListByCompanyCategory", map);
		} catch (Exception e) {
			System.out.println("getRentcarListByCompanyCategory() 에러");
			e.printStackTrace();
		}
		return list;
	}

	public Rentcar getARentcarByNum(int num) {
		Rentcar rentcar = null;
		try (SqlSession session = SqlSessionUtil.getSession().openSession()) {
			rentcar = session.selectOne("getARentcarByNo", num);
		} catch (Exception e) {
			System.out.println("getARentcarByNo() 에러");
			e.printStackTrace();
		}
		return rentcar;
	}

	public int updateTotalQty(Rentcar rentcar) {
		int cnt = 0;
		try (SqlSession session = SqlSessionUtil.getSession().openSession()) {
			cnt = session.update("updateTotalQty", rentcar);
			session.commit();
		} catch (Exception e) {
			System.out.println("updateTotalQty() 에러");
			e.printStackTrace();
		}
		return cnt;
	}


}
