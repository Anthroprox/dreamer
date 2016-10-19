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
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
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
        Iterable<Commentary> list = null;
        try {
            list = commentaryDao.findAll();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return (List<Commentary>) list;
    }
}
