package com.genetics.qmslogApi.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name =("first_name"))
    @NotBlank(message = "first name is required")
    private String firstname;

    @Column(name = "surname")
    @NotBlank(message = "surname is required")
    private String surname;

    @Email
    @NotBlank(message = "username is required")
    @Column(unique = true,name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name="role")
    private String role;

    @Column(name="branch")
    private String branch;

    public User() {
    }

    public User(int id, String firstname, String surname, String username, String password, String role, String branch) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.role = role;
        this.branch = branch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
