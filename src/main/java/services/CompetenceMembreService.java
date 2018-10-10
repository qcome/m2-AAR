package services;

import dao.CompetenceMembreDAO;
import model.CompetenceMembre;
import model.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CompetenceMembreService {

    @Autowired
    CompetenceMembreDAO dao;

    public Collection<CompetenceMembre> getCompetencesDisponibles(Membre m){
        return m.getCompetenceMembres();
    }
}
