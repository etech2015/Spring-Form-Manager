package com.example.demo.controller;

import com.example.demo.model.MyUser;
import com.example.demo.model.MyUserType;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("api")
public class MyController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTypeRepository userTypeRepository;

    @GetMapping("/users")
    public ResponseEntity<List<MyUser>> showAllUser() {
        List<MyUser> list = userRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/allusertype")
    public ResponseEntity<List<MyUserType>> getAllUserType(){
        List<MyUserType> list = userTypeRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("user")
    public ResponseEntity getUserByName(@RequestParam("name") String name) {
        MyUser user = userRepository.findByUserName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping("user/salary")
    public ResponseEntity getAllUserWithSalaryGreaterThan(@RequestParam("salary") int userSalary) {

        List<MyUser> userlist = userRepository.findByUserSalaryGreaterThanEqual(userSalary);
        return new ResponseEntity<>(userlist, HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity createUser(@RequestBody MyUser user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    @PutMapping("user")
    public ResponseEntity updateUser(@RequestBody MyUser userUpdate) {
        MyUser user = userRepository.findOne(userUpdate.getUserId());
        if (user == null) {
            return new ResponseEntity<>("User doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userRepository.save(userUpdate), HttpStatus.OK);
    }

    @DeleteMapping("user")
    public ResponseEntity deleteUser(@RequestParam("id") int userid) {
        MyUser user = userRepository.findOne(userid);
        if (user == null) {
            return new ResponseEntity<>("User doesn't exist", HttpStatus.NOT_FOUND);
        }
        userRepository.delete(userid);
        return new ResponseEntity<>("User has been deleted", HttpStatus.OK);
    }

}
