package tsi.ensg.projet.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tsi.ensg.projet.model.Participant;

@Repository
public interface ParticipantRepo extends CrudRepository<Participant, Long> {

}
