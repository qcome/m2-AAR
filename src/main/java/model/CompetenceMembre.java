package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "CompetenceMembre")
@Table(name = "COMPETENCE_MEMBRE")
public class CompetenceMembre implements Serializable {
    @Id
    @Column
    private int id;

    @Column
    private int niveau;
    @Column
    private String commentaire;

    @ManyToOne
    private Membre membre;

    @ManyToOne
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

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

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
