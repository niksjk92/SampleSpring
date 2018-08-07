package nikhil.test.spring5Webapp.bootstrap;

import nikhil.test.spring5Webapp.model.Author;
import nikhil.test.spring5Webapp.model.Book;
import nikhil.test.spring5Webapp.repositories.AuthorRepository;
import nikhil.test.spring5Webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        //Enid
        Author enid = new Author("Enid","Blyton");
        Book enidBooks = new Book("Five on a treasure Island","122enid134","somepublisher");
        enid.getBooks().add(enidBooks);
        enidBooks.getAuthors().add(enid);

        authorRepository.save(enid);
        bookRepository.save(enidBooks);

        //Rowling
        Author rowling = new Author("Joanne Kathaleen","Rowling");
        Book jkBooks = new Book("Harry Potter and the Philosopher's stone","1234JKR1","bloomsbury");
        rowling.getBooks().add(jkBooks);

        authorRepository.save(rowling);
        bookRepository.save(jkBooks);
    }
}
