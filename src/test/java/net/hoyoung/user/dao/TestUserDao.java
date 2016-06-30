package net.hoyoung.user.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import net.hoyoung.Setup;
import net.hoyoung.user.vo.User;

public class TestUserDao extends Setup {

	@Value("${jdbc.url}")
	private String url;
	
	@Autowired
	private UserMapper userDao;
	@Test
	public void testAdd() {
		User user = new User();
		user.setUsername("hoyoung");
		userDao.insert(user);
	}
}
