package com.BankingManagementSystem.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private Long loginId;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Customer customer;

    @Column(name = "role_type")
    private String roleType;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "isDefault")
    private Boolean isDefault;
    @Column(name = "lastLogin")
    private Timestamp lastLogin;

}
