/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.controllers;

import cr.ac.una.globales.database.dao.TypeDao;
import cr.ac.una.globales.database.entity.Type;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
public class TypeController {

    @Autowired
    private TypeDao typeDao;

    @RequestMapping(method = GET, path = "/type/list")
    @ResponseBody
    public List<Type> getList() {
        return (List<Type>) typeDao.findAll();
    }

    @RequestMapping(method = GET, path = "/type/find/{id}")
    @ResponseBody
    public Type getTypeById(@PathVariable("id") int id) {
        return typeDao.findOne(id);
    }

    @RequestMapping(method = POST, path = "/new/type")
    @ResponseBody
    public Integer newType(@RequestBody Type type) {
        return typeDao.save(type).getId();
    }
}
