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

    /**
     * find All Evenement in repo
     * @return List of all Evenement
     */
    public List<Evenement> findAll() {
        List<Evenement> events = (List<Evenement>) repository.findAll();
        return events;
    }

    /**
     * save an Evenement in repo
     * @param event
     */
    public void save(Evenement event) {  // pas testé avec persist !
        repository.save(event);
    }

    /**
     * find Evenement by his ID
     * @param id
     * @return an Evenement
     */
    public Optional<Evenement> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * delete an Evenement
     * @param event
     */
    public void delete(Evenement event) {
        repository.delete(event);
    }

    /**
     * Delete an Evenement with his ID
     * @param id
     */
    public void deleteById(Long id) {repository.deleteById(id);}


}