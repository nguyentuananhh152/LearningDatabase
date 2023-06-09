package com.example.learningdatabase.entity;
import javax.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id",  nullable = false, unique = true, length = 5)
    private int ID;

    @Column (name = "username", nullable = false, unique = true, length = 50)
    private String userName;

    @Column (name = "password", nullable = false, length = 50)
    private String passWord;

//    @OneToOne(cascade = CascadeType.PERSIST)
//    @NotFound(action = NotFoundAction.IGNORE)
//    @JoinColumn(name = "user")
//    private User user;
    @Column(name = "userid", nullable = false)
    private int UserID;


    @Column (name = "email", length = 50)
    private String Email;

    @Column (name = "isLogin")
    private Boolean IsLogin = false;

    public Account() {}

    public Account(String userName, String passWord, int userID, String email) {
        this.userName = userName;
        this.passWord = passWord;
        UserID = userID;
        Email = email;
    }

    public int getId() {
        return ID;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }

    public int getUserid() {
        return UserID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public Boolean IsLogin() {
        return IsLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.IsLogin = isLogin;
    }

    public boolean login(String userName, String passWord) {
        if (this.userName.equals(userName) && this.passWord.equals(passWord)) {
            return true;
        }
        return false;
    }
    @PrePersist()
    private void preInsert() {

    }
}
