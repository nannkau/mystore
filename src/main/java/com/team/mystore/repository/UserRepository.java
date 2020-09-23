package com.team.mystore.repository;

import com.team.mystore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByusername(String userName);

}
