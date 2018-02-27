package com.example.demo.repository;

import com.example.demo.model.MyUserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<MyUserType, Integer> {

}
