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
public class AgentAccount {
    
    private String accountNumber;
    private String AadharNumber;
    private String agentId;
    private String ifscCode;
    private Double balance;

    public AgentAccount() {
    }

    public AgentAccount(String accountNumber, String AadharNumber, String agentId, String ifscCode, Double balance) {
        this.accountNumber = accountNumber;
        this.AadharNumber = AadharNumber;
        this.agentId = agentId;
        this.ifscCode = ifscCode;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAadharNumber() {
        return AadharNumber;
    }

    public void setAadharNumber(String AadharNumber) {
        this.AadharNumber = AadharNumber;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    
    
}
