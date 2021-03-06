package net.hoyoung.user.dao;

import java.util.List;

import net.hoyoung.user.vo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    List<User> findSelective(User user);
}