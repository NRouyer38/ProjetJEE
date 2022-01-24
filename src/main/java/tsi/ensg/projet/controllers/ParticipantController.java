package tsi.ensg.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import tsi.ensg.projet.model.Participant;
import tsi.ensg.projet.services.ParticipantService;



@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@Controller
public class ParticipantController{


    @Autowired
    ParticipantService participantService;


    @GetMapping("/listParticipant")
    public String participantList (Model model) {

        model.addAttribute("participants", participantService.findAll());

        return "list_participant";
    }

    @GetMapping("/addParticipantForm")
    public String participantForm (Model model) {
        model.addAttribute("participant", new Participant());
        return "add_participant_form";
    }

    @PostMapping("/saveParticipant")
    public String participantSubmit(@ModelAttribute Participant participant, Model model) {
        model.addAttribute("participant", participant);
        participantService.save(participant);
        return "redirect:/listParticipant";
    }

    @GetMapping("/updateParticipant")
    public String showUpdateForm(@RequestParam Long id, Model model) {

        model.addAttribute("participant", participantService.findById(id).get());

        return "add_participant_form";
    }

    @GetMapping("/deleteParticipant")
    public String deleteParticipant(@RequestParam Long id) {
        participantService.deleteById(id);
        return "redirect:/listParticipant";
    }

}
