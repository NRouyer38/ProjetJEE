package tsi.ensg.projet.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tsi.ensg.projet.model.Evenement;

import java.util.Optional;

@Repository
public interface EvenementRepo extends CrudRepository<Evenement, Long> {

}
