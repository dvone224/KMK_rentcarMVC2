package kr.rentcar.model;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import kr.rentcar.util.SqlSessionUtil;

public class UserDAO {
	private UserDAO() {
	}

	private static UserDAO instance;

	public static UserDAO getInstance() {
		if (instance == null)
			instance = new UserDAO();
		return instance;
	}
	
	public int checkLogin(HashMap<String, String> map) {
		int no = -1;
		try (SqlSession session = SqlSessionUtil.getSession().openSession()) {
			no = session.selectOne("checkLogin", map);
		} catch (Exception e) {
			System.out.println("checkLogin() 에러");
			e.printStackTrace();
		}
		return no;
	}

	public boolean isValidId(String userId) {
		String currentId = null;
		try (SqlSession session = SqlSessionUtil.getSession().openSession()) {
			currentId = session.selectOne("isValidId", userId);
		} catch (Exception e) {
			System.out.println("isValidId() 에러");
			e.printStackTrace();
		}
		return currentId != null;
	}
}
