package com.fnl.demo.service.impl;

import com.fnl.demo.dao.mapper.SysRoleMapper;
import com.fnl.demo.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;
}
