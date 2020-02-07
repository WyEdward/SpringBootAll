package cn.wyedward.shiro;

import cn.wyedward.dao.UserDao;
import cn.wyedward.dao.UserPermissionDao;
import cn.wyedward.dao.UserRoleDao;
import cn.wyedward.domain.Permission;
import cn.wyedward.domain.Role;
import cn.wyedward.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm{
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private UserPermissionDao userPermissionDao;
    /**
     * 角色和权限验证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        String username = user.getUsername();
        System.out.println("用户" + username + "获取权限-----ShiroRealm.doGetAuthorizationInfo");

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //获取用户角色集
        List<Role> roleList = userRoleDao.findByUserName(username);
        Set<String> roleSet = new HashSet<>();
        for (Role r : roleList) {
            roleSet.add(r.getName());
        }
        simpleAuthorizationInfo.setRoles(roleSet);

        //获取用户权限集
        List<Permission> permissionList = userPermissionDao.findByUserName(username);
        Set<String> permissionSet = new HashSet<>();
        for (Permission p : permissionList) {
            permissionSet.add(p.getName());
        }
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }


    /**
     * 登录验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username =(String)authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        System.out.println("用户" + username + "认证-----ShiroRealm.doGetAuthenticationInfo");
        User user = userDao.findUserByName(username);
        if(user == null){
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if (user.getStatus().equals("0")) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
