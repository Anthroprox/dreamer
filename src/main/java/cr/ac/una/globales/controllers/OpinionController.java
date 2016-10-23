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
public class OpinionController {

    @Autowired
    private OpinionDao opinionDao;

    @RequestMapping(method = GET, path = "/opinion/list")
    @ResponseBody
    public List<Opinion> getList() {
        return (List<Opinion>) opinionDao.findAll();
    }

    @RequestMapping(method = GET, path = "/opinion/find/{id}")
    @ResponseBody
    public Opinion getOpinionById(@PathVariable("id") int id) {
        return opinionDao.findOne(id);
    }

    @RequestMapping(method = POST, path = "/opinion/new")
    @ResponseBody
    public Integer newOpinion(@RequestBody Opinion opinion) {
        return opinionDao.save(opinion).getId();
    }
}
