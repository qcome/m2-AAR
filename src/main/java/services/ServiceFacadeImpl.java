package services;

import model.Competence;
import model.CompetenceMembre;
import model.Membre;
import model.Projet;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceFacadeImpl implements ServiceFacade {



    private Map<String, Membre> membres;
    private Map<String, Competence> competences;
    private Map<String, Projet> projets;

    public ServiceFacadeImpl() {
        membres = new HashMap<>();
        competences = new HashMap<>();
        projets = new HashMap<>();

        Membre m1 = new Membre("quentin", "pass", "quentindeladrome");
        Membre m2 = new Membre("pernaut", "pass", "jpp");
        Membre m3 = new Membre("david", "pass", "dav");
        Membre m4 = new Membre("nocomp", "pass", "PasDeCompetences");
        membres.put(m1.getLogin(), m1);
        membres.put(m2.getLogin(), m2);
        membres.put(m3.getLogin(), m3);
        membres.put(m4.getLogin(), m4);


        Competence c1 = new Competence("j2ee", "java web");
        Competence c2 = new Competence("struts2", "framework j2ee");
        Competence c3 = new Competence("mariadb", "sgbd MySQL");
        Competence c4 = new Competence("symfony4", "framework web php");
        Competence c5 = new Competence("nginx", "serveur web");
        Competence c6 = new Competence("git", "gestionnaire versions");
        Competence c7 = new Competence("maven", "gestionnaire dépendances");
        Competence c8 = new Competence("angularjs", "framework js");
        competences.put(c1.getIntituleC(), c1);
        competences.put(c2.getIntituleC(), c2);
        competences.put(c3.getIntituleC(), c3);
        competences.put(c4.getIntituleC(), c4);
        competences.put(c5.getIntituleC(), c5);
        competences.put(c6.getIntituleC(), c6);
        competences.put(c7.getIntituleC(), c7);
        competences.put(c8.getIntituleC(), c8);

        new CompetenceMembre(2, "zaeaze", m1, c1);
        new CompetenceMembre(2, "zaeaze", m1, c2);
        new CompetenceMembre(3, "zaeaze", m1, c3);
        new CompetenceMembre(4, "zaeaze", m1, c4);
        new CompetenceMembre(2, "zaeaze", m1, c5);

        new CompetenceMembre(1, "zaeaze", m2, c1);
        new CompetenceMembre(1, "zaeaze", m2, c2);
        new CompetenceMembre(5, "zaeaze", m2, c3);

        new CompetenceMembre(5, "zaeaze", m3, c3);
        new CompetenceMembre(5, "zaeaze", m3, c4);
        new CompetenceMembre(5, "zaeaze", m3, c5);
        new CompetenceMembre(5, "zaeaze", m3, c6);
        new CompetenceMembre(5, "zaeaze", m3, c7);
        new CompetenceMembre(5, "zaeaze", m3, c8);

        Projet p1 = new Projet(m1, "Soundcloud bis", "Application web gestion playlists", new ArrayList<Competence>(){{add(c4);add(c3);add(c5);}});
        Projet p2 = new Projet(m1, "Wargame", "Application web struts jeu plateau", new ArrayList<Competence>(){{add(c2);add(c1);add(c3);add(c5);}});
        Projet p3 = new Projet(m3, "Leboncoin bis", "Application angularjs", new ArrayList<Competence>(){{add(c8);add(c6);add(c3);}});
        projets.put(p1.getIntituleP(), p1);
        projets.put(p2.getIntituleP(), p2);
        projets.put(p3.getIntituleP(), p3);
    }


    public String inscription(Membre membre) {

        return membre.getLogin();
    }

    @Override
    public Membre connexion(String login, String pass) {
        if(membres.containsKey(login)){
            Membre membre = membres.get(login);
            if(membre.getMotdepasse().equals(pass)){
                return membre;
            }
        }
        return null;
    }

    public List<String> getCompetencesLibelle(){
        ArrayList<String> competencesLibelle = new ArrayList<>();
        for (Competence c : competences.values()){
            competencesLibelle.add(c.getIntituleC());
        }
        return competencesLibelle;
    }

   /* public List<Competence> getCompetencesDisponibles(String login){
        List<Competence> temp = new ArrayList<>(competences.values());
        Membre membre = membres.get(login);
        for (CompetenceMembre c: membre.getCompetenceMembres()) {
            temp.remove(c.getCompetence());
        }
        return temp;
    }*/

    /*public List<CompetenceMembre> getCompetencesMembre(String login){
        Membre membre = membres.get(login);
        return membre.getCompetenceMembres();
    }*/

    public void ajouterCompetencesMembre(String login, String intituleCompetence, String niveau, String commentaire){
        Membre membre = membres.get(login);
        new CompetenceMembre(Integer.parseInt(niveau), commentaire, membre, competences.get(intituleCompetence));
    }

    public void ajouterProjet(String login, String intituleP, String descriptionP, String[] intituleCompetencesRequises){
        Membre dirigeant = membres.get(login);
        List<Competence> competencesRequises = new ArrayList<>();
        for(String intituleCompetence:intituleCompetencesRequises ){
            competencesRequises.add(competences.get(intituleCompetence));
        }
        Projet projet = new Projet(dirigeant, intituleP, descriptionP, competencesRequises);
        this.projets.put(projet.getIntituleP(), projet);
    }

    /*public void deleteCompetenceMembre(String login, String libelleCompetence){
        Membre membre = membres.get(login);
        membre.removeCompetenceMembre(libelleCompetence);
    }*/

    public List<Projet> getProjets(){
        return new ArrayList<>(projets.values());
    }

    public Membre getMembre(String login){
        return membres.get(login);
    }

}
