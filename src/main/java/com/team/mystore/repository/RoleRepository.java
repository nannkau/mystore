package com.team.mystore.repository;

import com.team.mystore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    public List<Role> findByFlagDelete(String flag);
}
