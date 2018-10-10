package model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Projet")
@Table(name="PROJET")
public class Projet implements Serializable {
    @Id
    @Column(name = "INTITULE")
    @Size(min = 4,message = "Au - 4 caractères...")
    private String intituleP;

    @Column(name = "DESCRIPTION")
    @Size(min = 4,message = "Au - 4 caractères...")
    private String descriptionP;

    @ManyToOne
    private Membre dirigeant;

    @Column(name = "AVANCEMENT")
    private int avancement;

    @ManyToMany
    private List<Competence> competencesRequises;

    @ManyToMany
    private List<Membre> participants;

    public Projet(){
        this.competencesRequises = new ArrayList<>();
        this.participants = new ArrayList<>();
        this.avancement = 0;
    }

    public Projet(Membre dirigeant, String intituleP, String descriptionP, List<Competence> competencesRequises){
        this();
        this.dirigeant = dirigeant;
        this.intituleP = intituleP;
        this.descriptionP = descriptionP;
        this.competencesRequises = competencesRequises;
        this.participants.add(dirigeant);
        //this.dirigeant.addProjetDirigeant(this);
    }

    public void addParticipant(Membre membre){
        this.participants.add(membre);
    }

    public void addCompetence(Competence competence){
        this.competencesRequises.add(competence);
    }

    public String getIntituleP() {
        return intituleP;
    }

    public void setIntituleP(String intituleP) {
        this.intituleP = intituleP;
    }

    public String getDescriptionP() {
        return descriptionP;
    }

    public void setDescriptionP(String descriptionP) {
        this.descriptionP = descriptionP;
    }

    public Membre getDirigeant() { return dirigeant; }

    public void setDirigeant(Membre dirigeant) { this.dirigeant = dirigeant; }

    public List<Competence> getCompetencesRequises() { return competencesRequises; }

    public void setCompetencesRequises(List<Competence> competencesRequises) { this.competencesRequises = competencesRequises; }

    public List<Membre> getParticipants() { return participants; }

    public void setParticipants(List<Membre> participants) { this.participants = participants; }

    public int getAvancement() { return avancement; }

    public void setAvancement(int avancement) { this.avancement = avancement; }

    @Override
    public String toString() {
        return "Projet{" +
                "intituleP='" + intituleP + '\'' +
                ", descriptionP='" + descriptionP + '\'' +
                ", dirigeant=" + dirigeant +
                ", competencesRequises=" + competencesRequises +
                ", participants=" + participants +
                '}';
    }
}
