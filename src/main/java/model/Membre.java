package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity(name = "Membre")
@Table(name="MEMBRE")
public class Membre implements Serializable {
    @Id
    @Column(name = "LOGIN")
    @Size(min = 4,message = "Au - 4 caractères...")
    private String login;
    @Column(name = "MOTDEPASSE")
    @Size(min = 4,message = "Au - 4 caractères...")
    private String motdepasse;
    @Column(name = "SURNOM", unique = true)
    @Size(min = 4,message = "Au - 4 caractères...")
    private String surnom;

    //private List<CompetenceMembre> competenceMembres;
    //private List<Projet> projetsDirigeant;
    //private List<Projet> projetsParticipant;


    public Membre(){
        //this.competenceMembres = new ArrayList<>();
        //this.projetsDirigeant = new ArrayList<>();
        //this.projetsParticipant = new ArrayList<>();
    }

    public Membre(String login, String motdepasse, String surnom) {
        this();
        this.login = login;
        this.motdepasse = motdepasse;
        this.surnom = surnom;
    }

    /*public void addCompetenceMembre(CompetenceMembre competenceMembre){
        this.competenceMembres.add(competenceMembre);
    }

    public void addProjetDirigeant(Projet projet){
        this.projetsDirigeant.add(projet);
        this.projetsParticipant.add(projet);
    }

    public void removeCompetenceMembre(String intituleCompetence){
        CompetenceMembre competenceMembre = null;
        for(CompetenceMembre cm : competenceMembres){
            if(cm.getCompetence().getIntituleC().equals(intituleCompetence)){
                competenceMembre = cm;
            }
        }
        this.competenceMembres.remove(competenceMembre);
    }


    public void addProjetParticipant(Projet projet){
        this.projetsParticipant.add(projet);
    }*/

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }
/*
    public List<CompetenceMembre> getCompetenceMembres() { return competenceMembres; }

    public void setCompetenceMembres(List<CompetenceMembre> competenceMembres) { this.competenceMembres = competenceMembres; }

    public List<Projet> getProjetsDirigeant() { return projetsDirigeant; }

    public void setProjetsDirigeant(List<Projet> projetsDirigeant) { this.projetsDirigeant = projetsDirigeant; }

    public List<Projet> getProjetsParticipant() { return projetsParticipant; }

    public void setProjetsParticipant(List<Projet> projetsParticipant) { this.projetsParticipant = projetsParticipant; }

    @Override
    public String toString() {
        return "Membre{" +
                "login='" + login + '\'' +
                ", motdepasse='" + motdepasse + '\'' +
                ", surnom='" + surnom + '\'' +
                ", competenceMembres=" + competenceMembres +
                ", projetsDirigeant=" + projetsDirigeant +
                ", projetsParticipant=" + projetsParticipant +
                '}';
    }*/
}
