package controllers;


import model.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import services.MembreService;
import services.ServiceFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@SessionAttributes("loginCourant")
@RequestMapping("/")
public class LoginController {

    @Autowired
    private MembreService service;

    @GetMapping(value = "/")
    public String root() {
        return "accueil";
    }

    @ModelAttribute("membre")
    public Membre setUpMembreForm() {
        return new Membre();
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("membre") Membre membre, BindingResult result,
                          HttpServletResponse response, Model model) throws IOException {

        if (result.hasErrors()) {
            return "accueil";
        }

        Membre m = service.connexion(membre.getLogin(), membre.getMotdepasse());

        if (m != null) {
            model.addAttribute("loginCourant", membre.getLogin());
            response.sendRedirect("/menu/");
        } else {
            result.addError(
                    new ObjectError("mlogin", "Utilisateur inconnu"));
        }
        return "accueil";
    }

    @GetMapping("/logout")
    public String doLogout(WebRequest request,HttpServletResponse response, SessionStatus status) throws IOException {
        status.setComplete();
        response.sendRedirect("/");
        return "accueil";
    }
}
