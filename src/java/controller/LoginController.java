/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoginDao;
import model.Session;
import model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author puspa
 */
    @RestController
@RequestMapping("/")
public class LoginController {
    private LoginDao loginDao;
    
    @ResponseBody
    @RequestMapping(value = "/login/{agentId}/{password}/{fingerprint}", method = RequestMethod.GET)
    public Session validateUser(@PathVariable String agentId, @PathVariable String password, @PathVariable String fingerprint) {
        Session session = null;
        try {
            session = loginDao.validateUser(agentId, password, fingerprint);
            
        } catch (Exception e) {
           new Session();
        }
    return session;
    }
    
    @RequestMapping("/fingerprint/{imei}")
    public User getUserDetails(@PathVariable String imei){
        User user = loginDao.getUserDetails(imei);
        return user;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
