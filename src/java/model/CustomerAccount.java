/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author puspa
 */

public class CustomerAccount {
    private String customerId;
    private String accountNumber;
    private String aadharNumber;
    private Double balance;
    private String ifscCode;
    private String nomineeName;
    private String relationship;
    private String nomineeDob;
    private String nomineeMajor;
    private String nomineeGuardianName;
    private String dateOfOpening;

    public CustomerAccount() {
    }

    public CustomerAccount(String customerId, String accountNumber, String aadharNumber, Double balance, String ifscCode, String nomineeName, String relationship, String nomineeDob, String nomineeMajor, String nomineeGuardianName, String dateOfOpening) {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.aadharNumber = aadharNumber;
        this.balance = balance;
        this.ifscCode = ifscCode;
        this.nomineeName = nomineeName;
        this.relationship = relationship;
        this.nomineeDob = nomineeDob;
        this.nomineeMajor = nomineeMajor;
        this.nomineeGuardianName = nomineeGuardianName;
        this.dateOfOpening = dateOfOpening;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getNomineeDob() {
        return nomineeDob;
    }

    public void setNomineeDob(String nomineeDob) {
        this.nomineeDob = nomineeDob;
    }

    public String getNomineeMajor() {
        return nomineeMajor;
    }

    public void setNomineeMajor(String nomineeMajor) {
        this.nomineeMajor = nomineeMajor;
    }

    public String getNomineeGuardianName() {
        return nomineeGuardianName;
    }

    public void setNomineeGuardianName(String nomineeGuardianName) {
        this.nomineeGuardianName = nomineeGuardianName;
    }

    public String getDateOfOpening() {
        return dateOfOpening;
    }

    public void setDateOfOpening(String dateOfOpening) {
        this.dateOfOpening = dateOfOpening;
    }

    
}
