/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.globales.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Rody
 */
@Entity
@Table(name = "opinion")
public class Opinion {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
      @OneToOne
    @JoinColumn(name = "user")
    private User user;
    
    @OneToOne
    @JoinColumn(name = "idea")
    private Idea idea;
    
    private int type;

    public Opinion(){}
    public Opinion(int id, User user, Idea idea, int type) {
        this.id = id;
        this.user = user;
        this.idea = idea;
        this.type = type;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the idea
     */
    public Idea getIdea() {
        return idea;
    }

    /**
     * @param idea the idea to set
     */
    public void setIdea(Idea idea) {
        this.idea = idea;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }
    
    
}
