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
public class Session {
    String agentId;
    String password;
    String fingerprint;
    String mobileNumber;
    String token;

    public Session() {
    }

    public Session(String agentId, String password, String fingerprint, String mobileNumber, String token) {
        this.agentId = agentId;
        this.password = password;
        this.fingerprint = fingerprint;
        this.mobileNumber = mobileNumber;
        this.token = token;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
}
