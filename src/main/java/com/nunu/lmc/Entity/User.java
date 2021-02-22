package com.nunu.lmc.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY,
            generator="uuid"
    )
    @GenericGenerator(
            name = "uuid",
            strategy = "uuid"
    )
    private String id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    public User() {
    }

    public User(String id, String userName, String fullname, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
    }

    public User(String userName, String fullname, String password, String email) {
        this.userName = userName;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
