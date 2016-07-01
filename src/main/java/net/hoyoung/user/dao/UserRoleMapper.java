package net.hoyoung.user.dao;

import java.util.List;

import net.hoyoung.user.vo.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
    
    List<UserRole> findSelective(UserRole record);
}