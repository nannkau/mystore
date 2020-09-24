package com.team.mystore.service;

import com.team.mystore.dto.UserDto;
import com.team.mystore.entity.User;

import java.util.List;

public interface UserService {
    public List<UserDto> findAll();
    public User add(UserDto category);
    public User update(UserDto category);
    public void deleteById(Integer id);

}
