package com.example.spring_test.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Admin {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

}
