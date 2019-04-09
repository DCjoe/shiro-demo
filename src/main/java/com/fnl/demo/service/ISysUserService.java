package com.fnl.demo.service;

import com.fnl.demo.dao.domain.SysUser;

public interface ISysUserService {
    SysUser getUserByUserName(String userName);
}
