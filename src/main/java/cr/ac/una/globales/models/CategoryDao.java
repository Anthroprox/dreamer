/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.models;


import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



/**
 *
 * @author Rody
 */
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer>{
    @Query("from Category  c where c.id=:categoryId")
    public Category findByCategory(@Param("categoryId") int categoryId);
}
