package com.BankingManagementSystem.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "deposits")
public class Deposits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transactionId;

    @ManyToOne
    @JoinColumn(name = "account_no", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "branch_no", nullable = false)
    private Branches branch;
    @Column(name = "depositer_name")
    private String depositerName;

    @Column(name = "acount_holder_type")
    private  String accountHolderType;

    @Column(name = "deposit_amount")
    private Double depositAmount;

    @Column(name = "deposit_date")
    private Timestamp depositDate;
}
