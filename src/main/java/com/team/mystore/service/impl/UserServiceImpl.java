package com.team.mystore.service.impl;

import com.team.mystore.dto.CategoryDto;
import com.team.mystore.dto.UserDto;
import com.team.mystore.entity.User;
import com.team.mystore.repository.UserRepository;
import com.team.mystore.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<UserDto> findAll() {
        List<UserDto> userDtoList = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            ModelMapper modelMapper = new ModelMapper();
            UserDto userDto = modelMapper.map(user, UserDto.class);
            userDtoList.add(userDto);
                }
        );
        return userDtoList;
    }

    @Override
    public User add(User category) {
        return null;
    }

    @Override
    public User update(User category) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
