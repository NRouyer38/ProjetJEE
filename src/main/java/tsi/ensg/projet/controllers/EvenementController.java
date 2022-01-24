package tsi.ensg.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import tsi.ensg.projet.model.Evenement;
import tsi.ensg.projet.services.ParticipantService;
import tsi.ensg.projet.services.EvenementService;


@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@Controller
public class EvenementController{

    @Autowired
    EvenementService evenementService;

    @Autowired
    ParticipantService participantService;

    /**
     * page for Get list of Evenement
     * @param model
     * @return list_evenement.html in /listEvenement
     */
    @GetMapping("/listEvenement")
    public String evenementList (Model model) {

        model.addAttribute("events", evenementService.findAll());

        return "list_evenement";
    }

    /**
     * page for Get form for add an Evenement
     * @param model
     * @return add_evenement_form.html in /addEvenementForm
     */
    @GetMapping("/addEvenementForm")
    public String evenementForm (Model model) {
        model.addAttribute("evenement", new Evenement());
        return "add_evenement_form";
    }

    /**
     * Save with Post an Evenement
     * @param evenement
     * @param model
     * @return redirect to list_evenement.html in /listEvenement
     */
    @PostMapping("/saveEvenement")
    public String evenementSubmit(@ModelAttribute Evenement evenement, Model model) {
        model.addAttribute("evenement", evenement);
        evenementService.save(evenement);
        return "redirect:/listEvenement";
    }

    /**
     * Get form for update an Evenement selected
     * @param id
     * @param model
     * @return add_evenement_form.html in /addEvenementForm
     * with select Evenement
     */
    @GetMapping("/updateEvenement")
    public String showUpdateForm(@RequestParam Long id, Model model) {

        model.addAttribute("evenement", evenementService.findById(id).get());

        return "add_evenement_form";
    }

    /**
     * Delete selected Evenement
     * @param id
     * @return redirect to list_evenement.html in /listEvenement
     */
    @GetMapping("/deleteEvenement")
    public String deleteEmployee(@RequestParam Long id) {
        evenementService.deleteById(id);
        return "redirect:/listEvenement";
    }

    /**
     * Home page with link on /listEvenement and /listParticipant
     * @return
     */
    @GetMapping("/home")
    public String home () {
        return "home.html";
    }

}