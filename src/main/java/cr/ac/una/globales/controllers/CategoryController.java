/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.controllers;

import cr.ac.una.globales.database.entity.Category;
import cr.ac.una.globales.database.dao.CategoryDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin()
@RestController
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(method = GET, path = "/category/list")
    @ResponseBody
    public List<Category> getList() {
        return (List<Category>) categoryDao.findAll();
    }

    @RequestMapping(method = GET, path = "/category/find/{id}")
    @ResponseBody
    public Category getListById(@PathVariable("id") int id) {
        return categoryDao.findOne(id);
    }

    @RequestMapping(method = POST, path = "/category/new")
    @ResponseBody
    public Integer newCategory(@RequestBody Category category) {
        return categoryDao.save(category).getId();
    }
}
