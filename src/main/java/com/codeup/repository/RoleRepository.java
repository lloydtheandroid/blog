package com.codeup.repository;

import com.codeup.models.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Query("select ur.role from UserRole ur, User u where u.username=?1 and ur.userId = u.id")
    List<String> ofUserWith(String username);
}
