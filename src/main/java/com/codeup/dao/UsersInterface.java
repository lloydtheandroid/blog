package com.codeup.dao;

import com.codeup.models.User;

public interface UsersInterface {
   User findByUsername(String username);
   void insert(User user);
   User update(long id);
   User find(long id);

}
