package dao;

import model.CompetenceMembre;
import model.Membre;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CompetenceMembreDAO {

    @PersistenceContext
    private EntityManager em;


    public CompetenceMembre get(int id) {
        return em.find(CompetenceMembre.class, id);
    }

    public List getCompetencesMembre(Membre m) {
        return em.createQuery("SELECT c FROM CompetenceMembre c where c.membre.login = ?1").setParameter(1, m.getLogin()).getResultList();
    }

    public CompetenceMembre findBy(int id) {
        return em.find(CompetenceMembre.class, id);
    }




}