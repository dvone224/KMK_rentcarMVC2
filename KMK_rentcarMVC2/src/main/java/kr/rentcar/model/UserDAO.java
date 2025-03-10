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
	
	public String checkLogin(HashMap<String, String> map) {
		String id = null;
		try (SqlSession session = SqlSessionUtil.getSession().openSession()) {
			id = session.selectOne("checkLogin", map);
		} catch (Exception e) {
			System.out.println("checkLogin() 에러");
			e.printStackTrace();
		}
		return id;
	}

	public boolean isValidId(String userId) {
		String currentId = null;
		try (SqlSession session = SqlSessionUtil.getSession().openSession()) {
			currentId = session.selectOne("isValidId", userId);
			System.out.println("currentId = " + currentId);
		} catch (Exception e) {
			System.out.println("isValidId() 에러");
			e.printStackTrace();
		}
		return currentId == null;
	}
	
	public int insertUser(User user) {
		int cnt = 0;
		try (SqlSession session = SqlSessionUtil.getSession().openSession()) {
			cnt = session.insert("insertUser", user);
		} catch (Exception e) {
			System.out.println("insertUser() 에러");
			e.printStackTrace();
		}
		return cnt;
	}
}
