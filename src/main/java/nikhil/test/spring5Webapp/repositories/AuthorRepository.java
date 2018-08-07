package nikhil.test.spring5Webapp.repositories;

import nikhil.test.spring5Webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface  AuthorRepository extends CrudRepository<Author, Long> {
}
