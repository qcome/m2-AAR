package controllers;


import model.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import services.MembreService;
import services.ServiceFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MembreService membreService;


    @GetMapping(value = "/")
    public String menu(@SessionAttribute(value="idCourant", required = false) Long id, HttpServletResponse response,
                       Model model) throws IOException {
        System.out.println(id);
        if(id == null){
            response.sendRedirect("/");
        }
        Membre user = membreService.getById(id);
        model.addAttribute("surnomCourant", user.getSurnom());
        return "menu";
    }
}
