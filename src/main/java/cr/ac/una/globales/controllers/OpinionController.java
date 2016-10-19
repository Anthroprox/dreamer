/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.controllers;

import cr.ac.una.globales.database.dao.OpinionDao;
import cr.ac.una.globales.database.entity.Opinion;
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
public class OpinionController {
    
    @Autowired
    private OpinionDao opinionDao;

    @RequestMapping(method = GET, path = "/opinion/list")
    @ResponseBody
    public List<Opinion> getList() {
        Iterable<Opinion> list = null;
        try {
            list = opinionDao.findAll();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return (List<Opinion>) list;
    }
}
