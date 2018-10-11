package dao;

import model.Membre;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * Created by douze on 09/10/2018.
 */
@Repository
public class MembreDAO {

    @PersistenceContext
    private EntityManager em;

    public Membre findById(Long id) {
        return em.find(Membre.class, id);
    }

    public Membre findBySurname(String surnom) {
        Query query = (Query) em.createQuery("SELECT m FROM Membre m where m.surnom = ?1").setParameter(1, surnom);
        Membre m;
        try{
            m = (Membre) query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
        return m;
    }

    public Membre findByLogin(String login) {
        Query query = (Query) em.createQuery("SELECT m FROM Membre m where m.login = ?1").setParameter(1, login);
        Membre m;
        try{
            m = (Membre) query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
        return m;
    }


    public Membre insert(Membre m){
        em.persist(m);
        return m;
    }
}
