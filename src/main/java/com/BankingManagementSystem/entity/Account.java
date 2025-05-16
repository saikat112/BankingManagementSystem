package com.BankingManagementSystem.entity;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_no_seq")
    @SequenceGenerator(name = "account_no_seq", sequenceName = "account_no_seq", allocationSize = 1)
    @Column(name = "account_no", unique = true, nullable = false)
    private Long accountNo;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
    @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq", allocationSize = 1)
    @Column(name = "customer_id", unique = true, nullable = false)
    private Long customerId;
    
    @@ManyToOne
    @JoinColumn(name = "branch_no", nullable = false)
    private Branches branch;
    @Column (name = "branch_name")
    private String branchName;
    @Column(name = "account_holder_type") // Joint || Individual
    private String accountHolderType;
    @Column (name ="no_account_holder")
    private int noAccountHolder;
    @Column (name = "name_p_o_f")
    private String NamePOF;
    @Column (name = "dob_f")
    private Date dobF;
    @Column (name = "age_f")
    private int ageF;
    @Column (name = "occupation_f")
    private String occupationF;
    @Column (name = "mobile_no_f")
    private String mobileNoF;
    @Column (name = "name_p_o_s")
    private String NamePOS;
    @Column (name = "dob_s")
    private Date dobS;
    @Column (name = "age_s")
    private int ageS;
    @Column (name = "occupation_s")
    private String occupationS;
    @Column (name = "mobile_no_s")
    private String mobileNoS;
    @Column (name = "account_type")
    private String accountType;
    @Column (name = "opening_balance")
    private double openingBalance;
    @Column(name = "account_holder_name", nullable = false)
    private String accountHolderName;
    private double  balance;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transactions> transactions;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Loans> loans;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cards> cards;


    @PrePersist
    public void generateAccountDetails() {
        if (this.accountNo == null) {
            // Simulate fetching the next sequence value
            this.accountNo = 1000000000000000L + this.id;
        }
        if (this.customerId == null) {
            // Simulate fetching the next sequence value
            this.customerId = 1000000000L + this.id;
        }
    }

    public Account( String accountHolderName, double balance){
        super();
//        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public Account() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Long getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getBranchName() {
        return branchName;
    }
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    public String getAccountHolderType() {
        return accountHolderType;
    }
    public void setAccountHolderType(String accountHolderType) {
        this.accountHolderType = accountHolderType;
    }
    public int getNoAccountHolder() {
        return noAccountHolder;
    }
    public void setNoAccountHolder(int noAccountHolder) {
        this.noAccountHolder = noAccountHolder;
    }
    public String getNamePOF() {
        return NamePOF;
    }
    public void setNamePOF(String namePOF) {
        NamePOF = namePOF;
    }
    public Date getDobF() {
        return dobF;
    }
    public void setDobF(Date dobF) {
        this.dobF = dobF;
    }
    public int getAgeF() {
        return ageF;
    }
    public void setAgeF(int ageF) {
        this.ageF = ageF;
    }
    public String getOccupationF() {
        return occupationF;
    }
    public void setOccupationF(String occupationF) {
        this.occupationF = occupationF;
    }
    public String getMobileNoF() {
        return mobileNoF;
    }
    public void setMobileNoF(String mobileNoF) {
        this.mobileNoF = mobileNoF;
    }
    public String getNamePOS() {
        return NamePOS;
    }
    public void setNamePOS(String namePOS) {
        NamePOS = namePOS;
    }
    public Date getDobS() {
        return dobS;
    }
    public void setDobS(Date dobS) {
        this.dobS = dobS;
    }
    public int getAgeS() {
        return ageS;
    }
    public void setAgeS(int ageS) {
        this.ageS = ageS;
    }
    public String getOccupationS() {
        return occupationS;
    }
    public void setOccupationS(String occupationS) {
        this.occupationS = occupationS;
    }
    public String getMobileNoS() {
        return mobileNoS;
    }
    public void setMobileNoS(String mobileNoS) {
        this.mobileNoS = mobileNoS;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public double getOpeningBalance() {
        return openingBalance;
    }
    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }


}
