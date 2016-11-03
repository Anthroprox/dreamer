/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.database.dao;

import cr.ac.una.globales.database.entity.Idea;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author Rody
 */
@Transactional
public interface IdeaDao extends CrudRepository<Idea, Integer> {
    @Query("SELECT idea FROM Idea as idea,  Opinion as opinion, Type as tipo where idea.id=opinion.idea.id and tipo.id=1 and idea.category.id=? group by idea.id order by count(idea.id) DESC")
    List<Idea> getIdeaCount(@Param("category") int category, Pageable pageable);   
    
     @Query(value="select * from idea order by date desc", nativeQuery=true)
    public List<Idea> getIdeasByDate();
}
