package com.codeup.dao;

import com.codeup.models.User;

public interface UsersInterface {
   User findByUsername(String username);
   void insert(User user);
   Integer updateUser(User user);
}
