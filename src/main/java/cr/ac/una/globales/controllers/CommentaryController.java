/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.controllers;

import cr.ac.una.globales.database.dao.CommentaryDao;
import cr.ac.una.globales.database.entity.Commentary;
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
public class CommentaryController {

    @Autowired
    private CommentaryDao commentaryDao;

    @RequestMapping(method = GET, path = "/commentary/list")
    @ResponseBody
    public List<Commentary> getList() {
        return (List<Commentary>) commentaryDao.findAll();
    }

    @RequestMapping(method = GET, path = "/commentary/find/{id}")
    @ResponseBody
    public Commentary getListById(@PathVariable("id") int id) {
        return commentaryDao.findOne(id);
    }

    @RequestMapping(method = POST, path = "/new/commentary")
    @ResponseBody
    public Integer newCommentary(@RequestBody Commentary commentary) {
        return commentaryDao.save(commentary).getId();
    }
}
