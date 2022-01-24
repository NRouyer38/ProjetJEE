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

    public List<Participant> findAll() {
        List<Participant> participant = (List<Participant>) repository.findAll();
        return participant;
    }

    public void save(Participant participant) {  // pas testé avec persist !
        repository.save(participant);
    }

    public Optional<Participant> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Participant participant) {
        repository.delete(participant);
    }
}