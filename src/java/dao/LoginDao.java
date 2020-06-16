/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.sql.DataSource;
import model.Session;
import model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author puspa
 */
public class LoginDao {
    
     private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Session validateUser(String agentId, String password, String fingerprint) {
      jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM USER_LOGIN WHERE AGENT_ID=? AND PASSWORD=? AND FINGERPRINT = ?";
        
       User user = jdbcTemplate.queryForObject(sql, new Object[]{agentId, password, fingerprint}, BeanPropertyRowMapper.newInstance(User.class));  
       Session session = new Session();
       session.setAgentId(user.getAgentId());
       session.setPassword(user.getPassword());
       session.setMobileNumber(user.getMobileNumber());
       
        return session;
    }
    
   public User getUserDetails(String imei){
       jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM USER_LOGIN WHERE AGENT_ID=?";
        
       User message = jdbcTemplate.queryForObject(sql, new Object[]{imei}, BeanPropertyRowMapper.newInstance(User.class));  
        
       return message;
        
    }
    
}
