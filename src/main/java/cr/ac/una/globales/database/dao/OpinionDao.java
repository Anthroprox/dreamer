/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.database.dao;

import cr.ac.una.globales.database.entity.Opinion;
import cr.ac.una.globales.database.entity.User;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Rody
 */
@Transactional
public interface OpinionDao extends CrudRepository<Opinion, Integer> {
    
    @Query(value="select * from opinion where user = :pUser and idea = :pIdea", nativeQuery=true)
    public Opinion findByUserAndIdea(@Param("pUser") Integer pUser, @Param("pIdea") Integer pIdea );
    
    @Query(value="select count(*) as approve  from opinion where idea =:pIdea and type = 1", nativeQuery=true)
    public Integer findTotalApproveFromIdea(@Param("pIdea") Integer pIdea );
    
    @Query(value="select count(*) as disapprove  from opinion where idea =:pIdea and type = 2", nativeQuery=true)
    public Integer findTotalDisApproveFromIdea(@Param("pIdea") Integer pIdea );
}
