package com.example.demo.repository;

import com.example.demo.model.MyUser;
import com.example.demo.model.MyUserType;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserRepository extends JpaRepository<MyUser, Integer>{

    MyUser findByUserName(String userName);
    List<MyUser> findByUserSalaryGreaterThanEqual(Integer salary);

}


