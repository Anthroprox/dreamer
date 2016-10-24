/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.controllers;

import cr.ac.una.globales.database.dao.UserDao;
import cr.ac.una.globales.database.entity.Category;
import cr.ac.una.globales.database.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Danel
 */
@CrossOrigin()
@RestController
public class LoginController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = GET, path = "/category/find/{id}/{password}")
    @ResponseBody
    public User login(@PathVariable("id") int id, @PathVariable("password") String password) {
        //return UserDao.findOne(id);
        return null;
    }

}
