package controllers;

import model.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.ServiceFacade;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/projets")
public class ProjetController {

    @Autowired
    private ServiceFacade serviceFacade;

    @ModelAttribute("projet")
    public Projet setUpProjetForm() {
        return new Projet();
    }

    @GetMapping(value = "/")
    public String root(@SessionAttribute(value="loginCourant", required = false) String log,
                       HttpServletResponse response, Model model) throws IOException {
        if(log == null){
            response.sendRedirect("/");
        }else{
            model.addAttribute("competences", serviceFacade.getCompetencesLibelle());
            //addAttributesToModel(model, serviceFacade.getMembre(log));
        }

        return "projets";
    }

    @PostMapping(value = "/addProjet")
    public String addProjet(@ModelAttribute("projet") Projet projet, Model model){
        System.out.println(12);
        model.addAttribute("competences", serviceFacade.getCompetencesLibelle());
        return "projets";
    }



   /* public void addAttributesToModel(Model model, Membre membre){
        model.addAttribute("courant", membre);
        model.addAttribute("competencesDispo", serviceFacade.getCompetencesDisponibles(membre.getLogin()));
        model.addAttribute("competences", serviceFacade.getCompetencesLibelle());
        model.addAttribute("competencesMembre", membre.getCompetenceMembres());
        List<Projet> projets = serviceFacade.getProjets();


        // Map permettant à la jsp de trier les projets en fonction du liens qu'à l'utilisateurs avec ceux-ci
        //(dirigeant, participant, compétentes associées....)

        Map<String, Map<String, Integer>> dataTableProjets = new HashMap<>();
        for(Projet projet: projets){
            Map<String, Integer> map = new HashMap<>();
            //check dirigeant
            Boolean isDirigeant = false;
            if(projet.getDirigeant() == membre)
                isDirigeant = true;
            map.put("isDirigeant", isDirigeant?1:0);

            //check participant
            Boolean isParticipant = false;
            if(projet.getParticipants().contains(membre))
                isParticipant = true;
            map.put("isParticipant", isParticipant?1:0);

            //check competences
            Boolean hasCompetences = false;
            Boolean competenceManquante = false;
            Boolean b = false;
            for(Competence competence: projet.getCompetencesRequises()){
                for(CompetenceMembre competenceMembre : membre.getCompetenceMembres()){
                    if(competenceMembre.getCompetence() == competence){
                        b = true;
                        break;
                    }
                }
                if(!b){
                    competenceManquante = true;
                    break;
                }
            }
            if(!competenceManquante)
                hasCompetences=true;
            map.put("hasCompetences", hasCompetences?1:0);
            dataTableProjets.put(projet.getIntituleP(), map);
        }
        model.addAttribute("projets", serviceFacade.getProjets());
        model.addAttribute("dataTableProjets", dataTableProjets);
    }*/

}
