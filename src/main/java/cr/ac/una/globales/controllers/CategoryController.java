/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.controllers;

import cr.ac.una.globales.models.Category;
import cr.ac.una.globales.models.CategoryDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rody
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(method = GET, path = "/category/list")
    @ResponseBody
    public List<Category> getList() {
        Iterable<Category> list = null;
        try {
            list = categoryDao.findAll();

        } catch (Exception ex) {
            
        }
        
        return (List<Category>) list;
    }

}