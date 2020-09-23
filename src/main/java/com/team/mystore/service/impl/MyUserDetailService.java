package com.team.mystore.service.impl;

import com.team.mystore.dto.MyUserDetail;
import com.team.mystore.entity.User;
import com.team.mystore.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByusername(userName);
       // user.orElseThrow(() -> new UsernameNotFoundException("not found "+userName));
        return new MyUserDetail(user);
    }
}
