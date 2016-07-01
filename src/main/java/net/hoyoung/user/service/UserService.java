package net.hoyoung.user.service;

import net.hoyoung.user.vo.User;

public interface UserService {
	public void add(User user);
	public User getByUsername(String username);
}
