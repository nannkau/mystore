package com.team.mystore.service;

import com.team.mystore.dto.UserDto;
import com.team.mystore.entity.Employee;
import com.team.mystore.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User add(User category);
    public User update(User category);
    public void deleteById(Integer id);
    public User findById(int id);


}
