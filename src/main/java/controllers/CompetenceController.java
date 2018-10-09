package controllers;

import model.CompetenceMembre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import services.ServiceFacade;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.swing.text.StyleConstants.ModelAttribute;

@Controller
@RequestMapping("/competences")
public class CompetenceController {

    @Autowired
    private ServiceFacade serviceFacade;

    @ModelAttribute("competenceMembre")
    public CompetenceMembre setUpCompetenceMembreForm() {
        return new CompetenceMembre();
    }




    @GetMapping(value = "/")
    public String root(@SessionAttribute(value="loginCourant", required = false) String log, HttpServletResponse response, Model model) throws IOException {
        if(log == null){
            response.sendRedirect("/");
        }
        //model.addAttribute("competencesDispo", serviceFacade.getCompetencesDisponibles(log));
        //model.addAttribute("competencesMembre", serviceFacade.getCompetencesMembre(log));

        return "competences";
    }

    @PostMapping(value = "/addCompetenceMembre")
    public String addCompetenceMembre(@ModelAttribute("competenceMembre") CompetenceMembre competenceMembre, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "competences";
        }
        return "competences";
    }

    @GetMapping(value = "/delete/{intitulleComp}")
    public String deleteCompetenceMembre(@SessionAttribute(value="loginCourant") String log, @PathVariable String intitulleComp, Model model) {
        /*serviceFacade.deleteCompetenceMembre(log, intitulleComp);
        model.addAttribute("competencesDispo", serviceFacade.getCompetencesDisponibles(log));
        model.addAttribute("competencesMembre", serviceFacade.getCompetencesMembre(log));*/


        return "competences";
    }
}
