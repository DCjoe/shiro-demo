package com.fnl.demo.service;

import java.util.List;

public interface ISysPermissionService {
    List<String> selectPermissionByUserId(Long userId);
}
