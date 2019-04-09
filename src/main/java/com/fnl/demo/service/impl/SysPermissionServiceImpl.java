package com.fnl.demo.service.impl;

import com.fnl.demo.dao.mapper.SysPermissionMapper;
import com.fnl.demo.service.ISysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionServiceImpl implements ISysPermissionService {

    @Autowired
    SysPermissionMapper sysPermissionMapper;

    @Override
    public List<String> selectPermissionByUserId(Long userId) {
        return sysPermissionMapper.selectPermissionByUserId(userId);
    }
}
