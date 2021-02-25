package com.biketrade.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biketrade.model.Role;

@Repository
public interface BTRoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);

}