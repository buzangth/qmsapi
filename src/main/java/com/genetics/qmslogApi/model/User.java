package com.genetics.qmslogApi.model;

import com.genetics.qmslogApi.security.ApplicationUserRole;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    //public enum Role{TELLER(),ADMIN(),BRANCH_MANAGER()}

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
    private List<ApplicationUserRole> role;

    @Column(name="branch")
    private String branch;

    public User() {
    }

    public User(int id, String firstname,String surname, String username, String password, List<ApplicationUserRole> role, String branch) {
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
        this.id = id;
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

    public List<ApplicationUserRole> getRole() {
        return role;
    }

    public void setRole(List<ApplicationUserRole> role) {
        this.role = role;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
