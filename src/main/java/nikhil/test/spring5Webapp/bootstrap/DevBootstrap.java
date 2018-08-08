package nikhil.test.spring5Webapp.bootstrap;

import nikhil.test.spring5Webapp.model.Author;
import nikhil.test.spring5Webapp.model.Book;
import nikhil.test.spring5Webapp.model.Publisher;
import nikhil.test.spring5Webapp.repositories.AuthorRepository;
import nikhil.test.spring5Webapp.repositories.BookRepository;
import nikhil.test.spring5Webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher bloomsbury = new Publisher("Bloomsbury","Avengers mansion","NewYork City","NY","665416");
        Publisher darkages = new Publisher("Dark Ages Books","Injustice Society","Deep underground","Earth","441254");
        Publisher jla = new Publisher("The Watchtower","Teleportation point 1","NewYork City","NY","00000");
        publisherRepository.save(bloomsbury);
        publisherRepository.save(darkages);
        publisherRepository.save(jla);
        //Enid
        Author enid = new Author("Enid","Blyton");
        Book enidBooks = new Book("Five on a treasure Island","122enid134",bloomsbury);
        enid.getBooks().add(enidBooks);
        enidBooks.getAuthors().add(enid);
        enid.getBooks().add(enidBooks);

        authorRepository.save(enid);
        bookRepository.save(enidBooks);

        //Rowling
        Author rowling = new Author("Joanne Kataleen","Rowling");
        Book jkBooks = new Book("Harry Potter and the Philosopher's stone","1234JKR1",darkages);
        rowling.getBooks().add(jkBooks);
        authorRepository.save(rowling);
        bookRepository.save(jkBooks);
        //Stephanie Meyer
        Author meyer = new Author("Stephanie","Meyer");
        Book meyerBook = new Book("Twilight","112341",darkages);
        meyerBook.getAuthors().add(meyer);
        meyer.getBooks().add(meyerBook);

        authorRepository.save(meyer);
        bookRepository.save(meyerBook);
        meyerBook = new Book("New Moon","123314",jla);
        meyerBook.getAuthors().add(meyer);
        meyer.getBooks().add(meyerBook);
        authorRepository.save(meyer);
        bookRepository.save(meyerBook);

    }
}

