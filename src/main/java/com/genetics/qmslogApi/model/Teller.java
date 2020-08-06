package com.genetics.qmslogApi.model;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name ="teller")
public class Teller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="teller_number")
    private int tellernumber;

    @Column(name ="teller_description")
    private String tellerdescription;

    @Column(name = "branch")
    private String branch;

    @Column(name ="service")
    private String service;

    @OneToOne
    private User user;




    public Teller() {
    }

    public Teller(int id, int tellernumber, String tellerdescription, String branch, String service,User user) {
        this.id = id;
        this.tellernumber = tellernumber;
        this.tellerdescription = tellerdescription;
        this.branch = branch;
        this.service = service;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public int getTellernumber() {
        return tellernumber;
    }

    public void setTellernumber(int tellernumber) {
        this.tellernumber = tellernumber;
    }

    public String getTellerdescription() {
        return tellerdescription;
    }

    public void setTellerdescription(String tellerdescription) {
        this.tellerdescription = tellerdescription;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
