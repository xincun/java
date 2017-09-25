package com.example.demo.jpa.respostiory;

import com.example.demo.jpa.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jdzfjfhnui on 2017-9-24.
 */
@Component
public interface UserJpaRespository extends JpaRepository<Users, Integer> {
    Users findByName(String name);

//    @Query("select  from users  where name=?1")
//    public Users getUsersByName(String name);
}
