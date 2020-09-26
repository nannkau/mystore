package com.team.mystore.repository;

import com.team.mystore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    public List<Role> findByFlagDelete(String flag);
}
