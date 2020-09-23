package com.team.mystore.service;

import com.team.mystore.dto.UserDto;
import com.team.mystore.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<UserDto> findAll();
    public User add(User category);
    public User update(User category);
    public void deleteById(Integer id);

}
