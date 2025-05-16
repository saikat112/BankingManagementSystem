package com.BankingManagementSystem.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;
    @ManyToOne
    @JoinColumn(name = "account_no", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "branch_no", nullable = false)
    private Branches branch;
    @Column(name = "transaction_type")
    private Long transactionType;
    @Column(name = "amount")
    private Double Amount;
    @Column(name = "transaction_date")
    private Timestamp transactionDate;
    @Column(name = "to_account_no")
    private Long toAccountNo;
    @Column(name = "status")
    private Long Status;
}
