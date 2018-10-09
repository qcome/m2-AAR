package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "CompetenceMembre")
@Table(name = "COMPETENCE_MEMBRE")
public class CompetenceMembre implements Serializable {
    @Column
    private int niveau;
    @Column
    private String commentaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membre_login", referencedColumnName = "login")
    private Membre membre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competence_intitule", referencedColumnName = "intituleC")
    private Competence competence;




    public CompetenceMembre(){

    }


    public CompetenceMembre(int niveau, String commentaire, Membre membre, Competence competence) {
        this.niveau = niveau;
        this.commentaire = commentaire;
        this.membre = membre;
        this.competence = competence;
        //this.membre.addCompetenceMembre(this);
        this.competence.addCompetenceMembre(this);
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Membre getMembre() { return membre; }

    public void setMembre(Membre membre) { this.membre = membre; }

    public Competence getCompetence() { return competence; }

    public void setCompetence(Competence competence) { this.competence = competence; }

    @Override
    public String toString() {
        return "CompetenceMembre{" +
                "niveau=" + niveau +
                ", commentaire='" + commentaire + '\'' +
                ", membre=" + membre +
                ", competence=" + competence +
                '}';
    }
}
