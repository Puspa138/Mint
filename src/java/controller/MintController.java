/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MintDao;
import model.AgentAccount;
import model.CustomerTransaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author puspa
 */
@RestController
@RequestMapping("/")
public class MintController {
    MintDao mintDao;

    public void setMintDao(MintDao mintDao) {
        this.mintDao = mintDao;
    }
    
    private String baseuri = "http://localhost:8080/BankApi";
    
    @RequestMapping(value="/deposit/{agentId}/{customerAadhar}/{customerAccount}/{amount}", method = RequestMethod.GET)
    public CustomerTransaction depositMoney(@PathVariable String agentId, @PathVariable String customerAadhar, @PathVariable String customerAccount, @PathVariable Double amount){
        
        AgentAccount agentDetails = mintDao.getAccount(agentId);
      String agentAccount = agentDetails.getAccountNumber();
       mintDao.updateAgentTransaction(agentId, customerAccount, amount);
      
        
        RestTemplate restTemplate = new RestTemplate();
        CustomerTransaction customerTransaction = restTemplate.getForObject(baseuri + "/transferFund/{agentAccount}/{customerAadhar}/{customerAccount}/{amount}", CustomerTransaction.class, new Object[] {agentAccount, customerAadhar, customerAccount, amount});     
        mintDao.updateCustomerTransaction(agentAccount, customerAadhar, customerAccount, amount);
        return customerTransaction;      
    }
      @RequestMapping(value = "/fundTransfer/{customerAccount}/{customerAadhar}/{amount}/{bAccount}/{bAadhar}")
    public CustomerTransaction fundTransfer(@PathVariable String customerAccount, @PathVariable String customerAadhar, @PathVariable Double amount, @PathVariable String bAccount, @PathVariable String bAadhar ){
    
         mintDao.transferMoney(customerAccount, customerAadhar, amount, bAadhar, bAccount);
        
        RestTemplate restTemplate = new RestTemplate();
        CustomerTransaction customerTransaction = restTemplate.getForObject(baseuri + "/moneyTransfer/{customerAadhar}/{customerAccount}/{amount}/{bAccount}/{bAadhar}", CustomerTransaction.class, new Object[] {customerAadhar, customerAccount, amount, bAccount, bAadhar});     
         return customerTransaction;
    }
    
    
}