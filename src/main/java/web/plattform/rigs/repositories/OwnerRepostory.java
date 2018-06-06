package web.plattform.rigs.repositories;

import org.springframework.data.repository.CrudRepository;
import web.plattform.rigs.model.Owner;

public interface OwnerRepostory extends CrudRepository<Owner, Long> {

}
