package nikhil.test.spring5Webapp.repositories;

import nikhil.test.spring5Webapp.model.Publisher;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
