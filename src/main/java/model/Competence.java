package model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "Competence")
@Table(name="COMPETENCE")
public class Competence implements Serializable {

    @Id
    @Column(name = "INTITULE")
    @Size(min = 4,message = "Au - 4 caractères...")
    private String intituleC;

    @Column(name = "DESCRIPTION")
    @Size(min = 4,message = "Au - 4 caractères...")
    private String descriptionC;


    @ManyToMany(mappedBy="competencesRequises")
    private List<Projet> projets;

    @OneToMany(mappedBy = "competence")
    private List<CompetenceMembre> competenceMembres;



    public Competence(){
        projets = new ArrayList<>();
        competenceMembres = new ArrayList<>();
    }

    public Competence(String intituleC, String descriptionC) {
        this();
        this.intituleC = intituleC;
        this.descriptionC = descriptionC;
    }


    public void addCompetenceMembre(CompetenceMembre competenceMembre){
        this.competenceMembres.add(competenceMembre);
    }

    public void addProjet(Projet projet){
        this.projets.add(projet);
    }

    public String getIntituleC() {
        return intituleC;
    }

    public void setIntituleC(String intituleC) {
        this.intituleC = intituleC;
    }

    public String getDescriptionC() {
        return descriptionC;
    }

    public void setDescriptionC(String descriptionC) {
        this.descriptionC = descriptionC;
    }

    public List<Projet> getProjets() { return projets; }

    public void setProjets(List<Projet> projets) { this.projets = projets; }

    public List<CompetenceMembre> getCompetenceMembres() { return competenceMembres; }

    public void setCompetenceMembres(List<CompetenceMembre> competenceMembres) { this.competenceMembres = competenceMembres; }

    @Override
    public String toString() {
        return "Competence{" +
                "intituleC='" + intituleC + '\'' +
                ", descriptionC='" + descriptionC + '\'' +
                ", projets=" + projets +
                ", competenceMembres=" + competenceMembres +
                '}';
    }
}
