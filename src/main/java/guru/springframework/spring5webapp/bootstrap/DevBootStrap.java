package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {

        Publisher rr = new Publisher();
        rr.setName("rr");
        rr.setAddress("hyd");
        publisherRepository.save(rr);
        Book rrr = new Book("RRR","India", rr);
        Author rm = new Author("Raja","Mouli");
        rm.getBooks().add(rrr);
        rrr.getAuthors().add(rm);
        authorRepository.save(rm);
        bookRepository.save(rrr);

        Publisher dp = new Publisher();
        dp.setName("dp");
        dp.setAddress("mum");
        publisherRepository.save(dp);
        Book kk = new Book("KK","India",dp);
        Author kj = new Author("Karan","Johar");
        kj.getBooks().add(kk);
        kk.getAuthors().add(kj);
        authorRepository.save(kj);
        bookRepository.save(kk);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
