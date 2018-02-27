package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "user_type")
public class MyUserType {

    public MyUserType() {
    }

    public MyUserType(int userTypeId, String userTypeName) {
        this.userTypeId = userTypeId;
        this.userTypeName = userTypeName;
    }

    @Id
    @Column(name = "user_type_id")
    private int userTypeId;

    @Column(name = "user_type_name")
    private String userTypeName;


    @OneToMany(mappedBy = "userType", cascade = CascadeType.ALL)
    private Set<MyUser> users;


    public int getUserTypeId() { return userTypeId; }

    public void setUserTypeId(int userTypeId) { this.userTypeId = userTypeId; }

    public String getUserTypeName() { return userTypeName; }

    public void setUserTypeName(String userTypeName) { this.userTypeName = userTypeName; }

}
