package com.codeup.dao;

import com.codeup.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersInterface extends JpaRepository<User, Long> {
   User findByUsername(String username);

   User findByUsernameIgnoreCase(String username);

   User findByEmailIgnoreCase(String email);

   User findByUsernameOrEmail(String username, String email);
}