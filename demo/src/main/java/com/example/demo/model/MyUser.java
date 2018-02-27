package com.example.demo.model;

import javax.persistence.*;

@Entity
@NamedQuery(name= "MyUser.findByUserName", query = "SELECT a FROM MyUser a WHERE  a.userName = (?1)")
@Table(name="user")
public class MyUser {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int userId;

    @Column(name = "name")
    private String userName;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "salary")
    private int userSalary;



    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private MyUserType userType;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(int userSalary) {
        this.userSalary = userSalary;
    }

    public MyUserType getUserType() { return userType; }

    public void setUserType(MyUserType userType) { this.userType = userType; }
}
