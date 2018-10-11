package controllers;

import exceptions.LoginDejaExistantException;
import exceptions.SurnomDejaExistantException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.MembreService;
import model.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@SessionAttributes("idCourant")
@RequestMapping("/inscription")
public class InscriptionController {

    @Autowired
    MembreService service;


    @ModelAttribute("membre")
    public Membre setUpMembreForm() {
        return new Membre();
    }

    @GetMapping(value = "/")
    public String root() {
        return "inscription";
    }


    @PostMapping(value = "/")
    public String inscription(@Valid @ModelAttribute("membre") Membre membre, BindingResult result,
                              HttpServletResponse response, Model model) throws IOException {
        if (result.hasErrors()) {
            return "inscription";
        }
        try {
            service.ajouterMembre(membre);
            model.addAttribute("idCourant", membre.getId());
            response.sendRedirect("/menu/");
        } catch (SurnomDejaExistantException e) {
            result.rejectValue("surnom", "error.membre", "Surnom déjà existant.");
        } catch (LoginDejaExistantException e) {
            result.rejectValue("login", "error.membre", "Login déjà existant.");
        }

        return "inscription";
    }

}
