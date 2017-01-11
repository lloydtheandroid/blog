package com.codeup.service;

import com.codeup.dao.RolesInterface;
import com.codeup.dao.UsersInterface;
import com.codeup.models.User;
import com.codeup.models.UserRole;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

@Service("customUserDetailsService")
public class UserDetailsLoader implements UserDetailsService {
    @Autowired
    private final UsersInterface users;

    @Autowired
    private final RolesInterface roles;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailsLoader(UsersInterface users, RolesInterface roles) {
        this.users = users;
        this.roles = roles;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        List<String> userRoles = roles.ofUserWith(username);
        return new UserWithRoles(user, userRoles);
    }
}