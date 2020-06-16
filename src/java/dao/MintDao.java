/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static java.lang.Double.parseDouble;
import javax.sql.DataSource;
import model.AgentAccount;
import model.AgentTransaction;
import model.CustomerAccount;
import model.CustomerTransaction;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author puspa
 */
public class MintDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public AgentAccount getAccount(String agentId) {
     jdbcTemplate = new JdbcTemplate(dataSource);
     String sql = "select * from AGENT_ACCOUNT where AGENT_ID = ?";
     AgentAccount agentAccount = jdbcTemplate.queryForObject(sql, new Object[]{agentId}, BeanPropertyRowMapper.newInstance(AgentAccount.class));
     return agentAccount;
    }
    
    public void updateAgentTransaction(String agentId,String customerAccount,Double amount){
    jdbcTemplate = new JdbcTemplate(dataSource);
    String sql = "select * from AGENT_ACCOUNT where AGENT_ID = ?";
    AgentAccount agentDetails = jdbcTemplate.queryForObject(sql, new Object[]{agentId}, BeanPropertyRowMapper.newInstance(AgentAccount.class));
    
   Double avl = agentDetails.getBalance();
   Double currentBalance = avl - amount;
   
    String sql1 = "INSERT INTO ROOT.AGENT_TRANSACTION (ACCOUNT_NUMBER, AMOUNT, TRANSACTION_TYPE, TRANSACTION_DATE, REMARK)VALUES (?, ?, ?, CURRENT_DATE, ?)";
    Integer result = jdbcTemplate.update(sql1, new Object[]{agentDetails.getAccountNumber(), amount, "transfer", "transferred to "+customerAccount});

    String sql2 = "update AGENT_ACCOUNT set BALANCE = ? where ACCOUNT_NUMBER  = ?";
    Integer result1 = jdbcTemplate.update(sql2, new Object[]{currentBalance, agentDetails.getAccountNumber()});
    }
    
    public void updateCustomerTransaction(String agentAccount,String customerAadhar,String customerAccount,Double amount){
        jdbcTemplate = new JdbcTemplate(dataSource);
      String sql = "select * from CUSTOMER_ACCOUNT where ACCOUNT_NUMBER = ? and AADHAR_NUMBER = ?";
      CustomerAccount customerDetails = jdbcTemplate.queryForObject(sql, new Object[]{customerAccount, customerAadhar}, BeanPropertyRowMapper.newInstance(CustomerAccount.class));
       
      Double avl = customerDetails.getBalance();
   Double currentBalance = avl + amount;
   
    String sql1 = "INSERT INTO ROOT.CUSTOMER_TRANSACTION (ACCOUNT_NUMBER, AMOUNT, TRANSACTION_TYPE, TRANSACTION_DATE, REMARK)VALUES (?, ?, ?, CURRENT_DATE, ?)";
    Integer result = jdbcTemplate.update(sql1, new Object[]{customerDetails.getAccountNumber(), amount, "transfer", "transferred from "+agentAccount});

    String sql2 = "update CUSTOMER_ACCOUNT set BALANCE = ? where ACCOUNT_NUMBER  = ?";
    Integer result1 = jdbcTemplate.update(sql2, new Object[]{currentBalance, customerDetails.getAccountNumber()});
    
     
    
    }
   
     public void transferMoney(String customerAccount, String customerAadhar, Double amount, String bAadhar, String bAccount) {
     jdbcTemplate = new JdbcTemplate(dataSource);
        //agent data
        String sql = "select * from CUSTOMER_ACCOUNT where ACCOUNT_NUMBER = ? and AADHAR_NUMBER = ?";
        CustomerAccount customerDetails = (CustomerAccount)jdbcTemplate.queryForObject(sql, new Object[]{customerAccount, customerAadhar}, BeanPropertyRowMapper.newInstance(CustomerAccount.class));
         
        // Customer data
        String sql1 = "select * from CUSTOMER_ACCOUNT where AADHAR_NUMBER = ? and ACCOUNT_NUMBER = ?";
        CustomerAccount bDetails = (CustomerAccount)jdbcTemplate.queryForObject(sql1, new Object[]{bAadhar,bAccount}, BeanPropertyRowMapper.newInstance(CustomerAccount.class));
        
        Double customerBalance, bBalance;
        customerBalance = customerDetails.getBalance();
        Double customerCurrentBalance = customerBalance - amount;
        bBalance = bDetails.getBalance();
        Double bCurrentBalance = bBalance + amount;
        
        String sql2 = "INSERT INTO ROOT.CUSTOMER_TRANSACTION (ACCOUNT_NUMBER,TRANSACTION_TYPE, AMOUNT, TRANSACTION_DATE, REMARK) VALUES (?, ?, ?, CURRENT_DATE, ?)";
        Integer result = jdbcTemplate.update(sql2, new Object[]{customerAccount,  "debit", amount, "transferred to"+bAccount});
        
        String sql3 = "INSERT INTO ROOT.CUSTOMER_TRANSACTION (ACCOUNT_NUMBER, TRANSACTION_TYPE, AMOUNT, TRANSACTION_DATE, REMARK) VALUES (?, ?, ?, CURRENT_DATE, ?)";
        Integer result1 = jdbcTemplate.update(sql3, new Object[]{bAccount, "credit", amount, "transferred from "+customerAccount});
        
           String sql5 = "update CUSTOMER_ACCOUNT set BALANCE = ? where ACCOUNT_NUMBER = ?";
            Integer result2 = jdbcTemplate.update(sql5, new Object[]{customerCurrentBalance,customerAccount});
            String sql6 = "update CUSTOMER_ACCOUNT set BALANCE=? where ACCOUNT_NUMBER = ?";
            Integer result3 = jdbcTemplate.update(sql6, new Object[]{bCurrentBalance,bAccount});
            
     }        
    
    
    
     }
        
    

