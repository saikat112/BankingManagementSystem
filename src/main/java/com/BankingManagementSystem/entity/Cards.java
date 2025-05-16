package com.BankingManagementSystem.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "cards")
public class Cards {
    @Id
    @Column(name = "card_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long cardNo;
    @ManyToOne
    @JoinColumn(name = "account_no", nullable = false)
    private Account account;
    @ManyToOne
    @JoinColumn(name = "branch_no", nullable = false)
    private Branches branch;
    @Column(name = "card_type")
    private String cardType;
    @Column(name = "issue_date")
    private Timestamp issueDate;
    @Column(name = "expiry_date")
    private Timestamp expiryDate;
    @Column(name = "card_status")
    private String cardStatus;
    @Column(name = "limit_amount")
    private Double limitAmount;
    @Column(name = "pin")
    private Integer pin;
}
