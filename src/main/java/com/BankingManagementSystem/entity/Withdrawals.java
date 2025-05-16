package com.BankingManagementSystem.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "withdrawals")
public class Withdrawals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "transaction_id" )
    private Long transactionId;
    @ManyToOne
    @JoinColumn(name = "account_no", nullable = false)
    private Account account;
    @ManyToOne
    @JoinColumn(name = "branch_no", nullable = false)
    private Branches branch;

    @Column (name = "withdrawee_name")
    private String withdraweeName;
    @Column(name = "account_holder_type")
    private String accountHolderType;
    @Column(name = "withdrawal_amount")
    private Double withdrawalAmount;
    @Column(name = "withdrawal_date")
    private Timestamp withdrawalDate;



}
