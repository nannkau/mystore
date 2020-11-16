package com.team.mystore.repository;

import com.team.mystore.entity.Employee;
import com.team.mystore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByusername(String userName);
    User findById(int id);


}
