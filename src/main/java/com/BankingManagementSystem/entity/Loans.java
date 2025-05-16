package com.BankingManagementSystem.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "loans")
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private long loanId;
    @ManyToOne
    @JoinColumn(name = "account_no", nullable = false)
    private Account account;
    @ManyToOne
    @JoinColumn(name = "branch_no", nullable = false)
    private Branches branch;
    @Column(name = "loan_sanctioned")
    private Double loanSanctioned;
    @Column(name = "no_installments")
    private long noInstallments;
    @Column(name = "emi")
    private Double emi;
    @Column(name = "issue_date")
    private Timestamp issueDate;
    @Column(name = "due_date")
    private Timestamp dueDate;
}
