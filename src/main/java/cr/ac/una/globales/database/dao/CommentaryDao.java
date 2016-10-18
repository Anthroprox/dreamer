/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.database.dao;

import cr.ac.una.globales.database.entity.Commentary;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Rody
 */
@Transactional
public interface CommentaryDao extends CrudRepository<Commentary, Integer>{
    
}
