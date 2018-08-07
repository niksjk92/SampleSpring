package nikhil.test.spring5Webapp.repositories;

import nikhil.test.spring5Webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
