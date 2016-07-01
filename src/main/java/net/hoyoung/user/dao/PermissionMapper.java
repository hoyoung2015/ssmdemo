package net.hoyoung.user.dao;

import java.util.List;

import net.hoyoung.user.vo.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    List<Permission> findSeletive(Permission permission);
}