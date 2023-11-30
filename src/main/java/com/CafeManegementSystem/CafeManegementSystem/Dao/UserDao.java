package com.CafeManegementSystem.CafeManegementSystem.Dao;

import com.CafeManegementSystem.CafeManegementSystem.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    User findByEmailId(@Param("email") String email);


}
