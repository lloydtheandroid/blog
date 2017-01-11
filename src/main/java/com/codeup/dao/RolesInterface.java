package com.codeup.dao;

import com.codeup.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface RolesInterface extends JpaRepository<UserRole, Long> {

    UserRole findByName(String name);

    @Query("select ur.role from UserRole ur, User u where u.username=?1 and ur.userId = u.id")
    public List<String> ofUserWith(String username);
}
