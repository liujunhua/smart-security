package com.smart.security.auth.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.security.auth.entity.Permission;
import com.smart.security.auth.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liujunhua
 * @description: PermissionService
 * @date 2020/8/716:50
 */
@Service
public class PermissionService extends ServiceImpl<PermissionMapper, Permission> {

    @Autowired
    private PermissionMapper permissionMapper;

    public List<Permission> getByUserId(Long userId) {
        return permissionMapper.queryByUserId(userId);
    }
}
