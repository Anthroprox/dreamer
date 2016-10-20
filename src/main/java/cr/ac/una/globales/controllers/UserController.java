/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.controllers;

import cr.ac.una.globales.database.dao.UserDao;
import cr.ac.una.globales.database.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rody
 */
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = GET, path = "/user/list")
    @ResponseBody
    public List<User> getList() {
        return (List<User>) userDao.findAll();
    }

    @RequestMapping(method = POST, path = "/new/user")
    @ResponseBody
    public Integer newUser(@RequestBody User user) {
        return userDao.save(user).getId();
    }
}
