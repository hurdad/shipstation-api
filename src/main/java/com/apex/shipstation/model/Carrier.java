package com.apex.shipstation.model;

public class Carrier {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isRequiresFundedAccount() {
        return requiresFundedAccount;
    }

    public void setRequiresFundedAccount(boolean requiresFundedAccount) {
        this.requiresFundedAccount = requiresFundedAccount;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    private String name;
    private String code;
    private String accountNumber;
    private boolean requiresFundedAccount;
    private float balance;

}