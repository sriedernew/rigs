package web.plattform.rigs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.plattform.rigs.repositories.OwnerRepostory;

@Controller
public class OwnerController {

    private OwnerRepostory ownerRepostory;

    public OwnerController(OwnerRepostory ownerRepostory){
        this.ownerRepostory = ownerRepostory;
    }

    @RequestMapping("/owners")
    public String getOwners(Model model){
        model.addAttribute("owners",ownerRepostory.findAll());
        return "owners";
    }
}
