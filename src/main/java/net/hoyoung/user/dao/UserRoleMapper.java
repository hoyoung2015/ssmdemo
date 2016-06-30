package net.hoyoung.user.dao;

import net.hoyoung.user.vo.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}