/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.controllers;

import cr.ac.una.globales.database.dao.IdeaDao;
import cr.ac.una.globales.database.entity.Idea;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class IdeaController {

    @Autowired
    private IdeaDao ideaDao;

    @RequestMapping(method = GET, path = "/idea/list")
    @ResponseBody
    public List<Idea> getList() {
        return (List<Idea>) ideaDao.findAll();
    }
    @RequestMapping(method = GET, path = "/idea/date/list")
    @ResponseBody
    public List<Idea> getIdeasByDate(){
        return (List<Idea>) ideaDao.getIdeasByDate();
    }

    @RequestMapping(method = GET, path = "/idea/find/{id}")
    @ResponseBody
    public Idea getListById(@PathVariable("id") int id) {
        return ideaDao.findOne(id);
    }

    @RequestMapping(method = POST, path = "/idea/new")
    @ResponseBody
    public Integer newIdea(@RequestBody Idea idea) {
        return ideaDao.save(idea).getId();
    }
    
    @RequestMapping(method = GET, path = "/idea/top/{id}")
    @ResponseBody
    public List<Idea>  getIdeaCount(@PathVariable("id") int id) {
        Pageable topTen = new PageRequest(0, 10);
        return ideaDao. getIdeaCount(id,topTen);
    }
    
   
    
}
