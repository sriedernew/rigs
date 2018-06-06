package web.plattform.rigs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.plattform.rigs.repositories.RigRepository;

@Controller
public class RigController {

    private RigRepository rigRepository;

    public RigController(RigRepository rigRepository){
        this.rigRepository = rigRepository;
    }

    @RequestMapping("/rigs")
    public String getRigs(Model model){
        model.addAttribute("rigs",rigRepository.findAll());
        return "rigs";
    }
}
