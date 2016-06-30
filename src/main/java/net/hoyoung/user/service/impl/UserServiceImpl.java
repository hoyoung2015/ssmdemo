package net.hoyoung.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.hoyoung.user.dao.UserMapper;
import net.hoyoung.user.service.UserService;
import net.hoyoung.user.vo.User;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public void add(User user) {
		userMapper.insert(user);
	}

}
