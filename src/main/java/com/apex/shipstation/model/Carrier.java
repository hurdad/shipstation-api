package com.apex.shipstation.model;

public class Carrier {

    private String name;
    private String nickname;
    private String code;
    private String accountNumber;
    private boolean requiresFundedAccount;
    private float balance;
    private int shippingProviderId;
    private boolean primary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public int getShippingProviderId() {
        return shippingProviderId;
    }

    public void setShippingProviderId(int shippingProviderId) {
        this.shippingProviderId = shippingProviderId;
    }

    public boolean getPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

}
