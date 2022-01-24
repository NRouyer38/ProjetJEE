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

    /**
     * page for Get list of Participant
     * @param model
     * @return list_participant.html in /listParticipant
     */
    @GetMapping("/listParticipant")
    public String participantList (Model model) {

        model.addAttribute("participants", participantService.findAll());

        return "list_participant";
    }

    /**
     * page for Get form for add an Participant
     * @param model
     * @return add_participant_form.html in /addParticipantForm
     */
    @GetMapping("/addParticipantForm")
    public String participantForm (Model model) {
        model.addAttribute("participant", new Participant());
        return "add_participant_form";
    }

    /**
     * Save with Post an Participant
     * @param participant
     * @param model
     * @return redirect to list_participant.html in /listParticipant
     */
    @PostMapping("/saveParticipant")
    public String participantSubmit(@ModelAttribute Participant participant, Model model) {
        model.addAttribute("participant", participant);
        participantService.save(participant);
        return "redirect:/listParticipant";
    }

    /**
     * Get form for update an Participant selected
     * @param id
     * @param model
     * @return add_participant_form.html in /addParticipantForm
     * with select Participant
     */
    @GetMapping("/updateParticipant")
    public String showUpdateForm(@RequestParam Long id, Model model) {

        model.addAttribute("participant", participantService.findById(id).get());

        return "add_participant_form";
    }

    /**
     * Delete selected Participant
     * @param id
     * @return redirect to list_participant.html in /listParticipant
     */
    @GetMapping("/deleteParticipant")
    public String deleteParticipant(@RequestParam Long id) {
        participantService.deleteById(id);
        return "redirect:/listParticipant";
    }
}
