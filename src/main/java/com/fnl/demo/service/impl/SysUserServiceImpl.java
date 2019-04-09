package com.fnl.demo.service.impl;

import com.fnl.demo.dao.domain.SysUser;
import com.fnl.demo.dao.mapper.SysUserMapper;
import com.fnl.demo.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserByUserName(String userName) {
        return sysUserMapper.getUserByUserName(userName);
    }
}
