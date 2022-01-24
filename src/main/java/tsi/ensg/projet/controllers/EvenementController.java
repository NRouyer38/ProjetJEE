package tsi.ensg.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import tsi.ensg.projet.model.Evenement;
import tsi.ensg.projet.model.Participant;
import tsi.ensg.projet.repositories.EvenementRepo;
import tsi.ensg.projet.services.ParticipantService;
import tsi.ensg.projet.services.EvenementService;

import java.util.List;
import java.util.Scanner;


@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@Controller
public class EvenementController{

    @Autowired
    EvenementService evenementService;

    @Autowired
    ParticipantService participantService;


    @GetMapping("/listEvenement")
    public String evenementList (Model model) {

        model.addAttribute("events", evenementService.findAll());

        return "list_evenement";
    }

    @GetMapping("/addEvenementForm")
    public String evenementForm (Model model) {
        model.addAttribute("evenement", new Evenement());
        return "add_evenement_form";
    }

    @PostMapping("/saveEvenement")
    public String evenementSubmit(@ModelAttribute Evenement evenement, Model model) {
        model.addAttribute("evenement", evenement);
        evenementService.save(evenement);
        return "redirect:/listEvenement";
    }

    @GetMapping("/updateEvenement")
    public String showUpdateForm(@RequestParam Long id, Model model) {

        model.addAttribute("evenement", evenementService.findById(id).get());

        return "add_evenement_form";
    }

    @GetMapping("/deleteEvenement")
    public String deleteEmployee(@RequestParam Long id) {
        evenementService.deleteById(id);
        return "redirect:/listEvenement";
    }

    @GetMapping("/home")
    public String home () {
        return "JEEHome.html";
    }
}