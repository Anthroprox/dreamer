/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.database.dao;

import cr.ac.una.globales.database.entity.Commentary;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Rody
 */
@Transactional
public interface CommentaryDao extends CrudRepository<Commentary, Integer>{
    @Query("SELECT commentary FROM Commentary as commentary where commentary.idea.id=?")
    List<Commentary> getCommentaryByIdea(@Param("idea") int idea);   

}
