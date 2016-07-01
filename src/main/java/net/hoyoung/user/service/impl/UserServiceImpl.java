package net.hoyoung.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

	@Override
	public User getByUsername(String username) {
		User user = new User();
		user.setUsername("tom");
		List<User> users = userMapper.findSelective(user);
		
		return CollectionUtils.isEmpty(users)?null:users.get(0);
	}

}
