package com.smart.security.auth.service;

import com.smart.security.auth.entity.Permission;
import com.smart.security.auth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujunhua
 * @description: UserDetailsServiceImpl
 * @date 2020/8/716:41
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("userName: " + userName + "is not exist!");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Permission> permissions = permissionService.getByUserId(user.getId());
        permissions.forEach(permission -> {
            authorities.add(new SimpleGrantedAuthority(permission.getEname()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

}
