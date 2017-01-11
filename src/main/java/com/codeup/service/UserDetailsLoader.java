package com.codeup.service;

import com.codeup.repository.RolesInterface;
import com.codeup.repository.UsersInterface;
import com.codeup.models.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

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