package tsi.ensg.projet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsi.ensg.projet.model.Participant;
import tsi.ensg.projet.repositories.ParticipantRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepo repository;

    /**
     * find All Participant in repo
     * @return List of all Participant
     */
    public List<Participant> findAll() {
        List<Participant> participant = (List<Participant>) repository.findAll();
        return participant;
    }

    /**
     * save an Participant in repo
     * @param participant
     */
    public void save(Participant participant) {  // pas testé avec persist !
        repository.save(participant);
    }

    /**
     * find Participant by his ID
     * @param id
     * @return an Participant
     */
    public Optional<Participant> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * delete a Participant
     * @param participant
     */
    public void delete(Participant participant) {
        repository.delete(participant);
    }

    /**
     * delete a Participant by his ID
     * @param id
     */
    public void deleteById(Long id) {repository.deleteById(id);}
}