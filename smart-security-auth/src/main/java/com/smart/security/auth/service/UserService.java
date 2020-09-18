package com.smart.security.auth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.security.auth.entity.User;
import com.smart.security.auth.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liujunhua
 * @description: UserService
 * @date 2020/8/716:26
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    public User getUserByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername, username);
        List<User> users = baseMapper.selectList(queryWrapper);
        return users.stream().findFirst().get();
    }
}
