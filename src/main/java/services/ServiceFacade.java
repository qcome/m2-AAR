package services;

import model.Membre;
import model.Projet;

import java.util.List;

public interface ServiceFacade {
    public String inscription(Membre membre);
    public Membre connexion(String login, String pass);
    public Membre getMembre(String login);

    public List<String> getCompetencesLibelle();
    //public List<Competence> getCompetencesDisponibles(String login);
    //public List<CompetenceMembre> getCompetencesMembre(String login);
    //public void deleteCompetenceMembre(String login, String libelleCompetence);

    public void ajouterCompetencesMembre(String login, String intituleCompetence, String niveau, String commentaire);
    public void ajouterProjet(String login, String intituleP, String descriptionP, String[] intituleCompetencesRequises);

    public List<Projet> getProjets();

}
