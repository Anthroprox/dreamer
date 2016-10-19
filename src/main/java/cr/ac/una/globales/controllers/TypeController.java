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
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
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
        Iterable<Type> list = null;
        try {
            list = typeDao.findAll();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return (List<Type>) list;
    }
    
     @RequestMapping(method = GET, path = "/type/find/{id}")
     @ResponseBody
     public Type getTypeById(@PathVariable("id") int id) {
        Type list = new Type();
        try {
            list = typeDao.findOne(id);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return  list;
        
    }
}
