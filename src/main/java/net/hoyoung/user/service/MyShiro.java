package net.hoyoung.user.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import net.hoyoung.user.dao.PermissionMapper;
import net.hoyoung.user.dao.RoleMapper;
import net.hoyoung.user.dao.UserMapper;
import net.hoyoung.user.dao.UserRoleMapper;
import net.hoyoung.user.vo.Permission;
import net.hoyoung.user.vo.Role;
import net.hoyoung.user.vo.User;
import net.hoyoung.user.vo.UserRole;

@Service("myShiro")
public class MyShiro extends AuthorizingRealm {

	@Resource
	private UserMapper userMapper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private UserRoleMapper userRoleMapper;
	@Resource
	private PermissionMapper permissionMapper;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		 //获取登录时输入的用户名  
        String loginName=(String) principalCollection.fromRealm(getName()).iterator().next();  
        //到数据库查是否有此对象  
        User user = new User();
		user.setUsername(loginName);
		List<User> users = userMapper.findSelective(user);

		User userdb = CollectionUtils.isEmpty(users) ? null : users.get(0);
		
		
		
        if(userdb!=null){  
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();  
            //用户的角色集合  
            UserRole ur = new UserRole();
    		ur.setUserId(userdb.getId());
    		List<UserRole> list = userRoleMapper.findSelective(ur);
            Set<String> rolesName = new HashSet<>();
            Set<String> permissionsName = new HashSet<>();
            for(UserRole var:list){
            	Role role = roleMapper.selectByPrimaryKey(var.getRoleId());
            	if(role!=null){
            		rolesName.add(role.getRoleName());
            		Permission p = new Permission();
            		p.setRoleId(role.getId());
            		List<Permission> plist = permissionMapper.findSeletive(p);
            		for(Permission var1:plist){
            			permissionsName.add(var1.getPerName());
            		}
            	}
            }
            
            info.setRoles(rolesName);  
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要  
            info.addStringPermissions(permissionsName);  
            return info;  
        }  
        return null;  
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken tocken = (UsernamePasswordToken) authenticationToken;
		User user = new User();
		user.setUsername(tocken.getUsername());
		List<User> users = userMapper.findSelective(user);

		User userdb = CollectionUtils.isEmpty(users) ? null : users.get(0);
		AuthenticationInfo authenticationInfo = null;
		if (userdb != null) {
			// 若存在，将此用户存放到登录认证info中
			authenticationInfo = new SimpleAuthenticationInfo(userdb.getUsername(), userdb.getPassword(), getName());
		}
		return authenticationInfo;
	}
	public void findTest(){
		UserRole ur = new UserRole();
		ur.setUserId(1);
		List<UserRole> list = userRoleMapper.findSelective(ur);
		for(UserRole var : list){
			System.out.println(var.toString());
		}
	}
}
