package com.BankingManagementSystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "banches")
public class Branches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_no")
    private Long branchNo;

    @Column(name = "branch_name", nullable = false)
    private String branchName;

    @Column(name = "ifsc_code", unique = true, nullable = false)
    private  String ifceCode;

    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Loans> loans;


}
