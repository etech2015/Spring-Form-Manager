package com.example.demo.controller;

import com.example.demo.model.MyUser;
import com.example.demo.model.MyUserType;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")

public class GUIController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @GetMapping("/all")
    public String welcome(Map<String, Object> model) {
        List<MyUser> lstUser = userRepository.findAll();
        List<MyUserType> lstUserType = userTypeRepository.findAll();
        model.put("allUser", lstUser);
        model.put("user", new MyUser());
        model.put("allUserType", lstUserType);
        return "GUI";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int userId) {
        userRepository.delete(userId);
        return "redirect:/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int userId, Map<String, Object> model) {
        List<MyUser> lstUser = userRepository.findAll();
        List<MyUserType> lstUserType = userTypeRepository.findAll();
        MyUser user = userRepository.findOne(userId);
        model.put("allUser", lstUser);
        model.put("user", user);
        model.put("allUserType", lstUserType);
        return "GUI";
    }


    @PostMapping("/addUser")
    public String add(@ModelAttribute("myUser") MyUser myUser) {
        userRepository.save(myUser);
        return "redirect:/all";
    }

}
