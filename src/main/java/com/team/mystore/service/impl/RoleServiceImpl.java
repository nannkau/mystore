package com.team.mystore.service.impl;

import com.team.mystore.entity.Role;
import com.team.mystore.repository.RoleRepository;
import com.team.mystore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Optional<Role> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Role> findByFlagDelete(String flag) {
        return roleRepository.findByFlagDelete(flag);
    }
}
