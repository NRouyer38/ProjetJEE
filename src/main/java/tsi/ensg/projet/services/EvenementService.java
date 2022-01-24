package tsi.ensg.projet.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsi.ensg.projet.model.Evenement;
import tsi.ensg.projet.repositories.EvenementRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EvenementService {

    @Autowired
    private EvenementRepo repository;

    public List<Evenement> findAll() {
        List<Evenement> events = (List<Evenement>) repository.findAll();
        return events;
    }

    public void save(Evenement event) {  // pas testé avec persist !
        repository.save(event);
    }

    public Optional<Evenement> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Evenement event) {
        repository.delete(event);
    }

    public void deleteById(Long id) {repository.deleteById(id);}


}