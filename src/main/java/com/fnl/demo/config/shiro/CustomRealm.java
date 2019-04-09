package com.fnl.demo.config.shiro;

import com.fnl.demo.dao.domain.SysUser;
import com.fnl.demo.service.ISysPermissionService;
import com.fnl.demo.service.ISysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    ISysUserService sysUserService;
    @Autowired
    ISysPermissionService sysPermissionService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();
        List<String> sysPermissions = sysPermissionService.selectPermissionByUserId(sysUser.getUserId());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(sysPermissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();
        SysUser sysUser = sysUserService.getUserByUserName(userName);
        if (sysUser == null) {
            return null;
        }
        //principal：认证的实体信息，可以是username，也可以是数据库表对应的用户的实体对象
        //credentials：数据库中的密码（经过加密的密码）
        //realmName：当前realm对象的name，调用父类的getName()方法即可
        return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), getName());
    }
}
