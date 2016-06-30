package net.hoyoung.user.service;

import javax.annotation.Resource;

import org.junit.Test;

import net.hoyoung.Setup;
import net.hoyoung.user.vo.User;

public class TestUserService extends Setup {
	@Resource
	private UserService userService;
	@Test
	public void testAdd(){
		User user = new User();
		user.setUsername("hahha");
		userService.add(user);
		System.out.println("success");
	}
}
