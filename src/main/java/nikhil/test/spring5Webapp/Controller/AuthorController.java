package nikhil.test.spring5Webapp.Controller;

import nikhil.test.spring5Webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String authors(Model model){
        model.addAttribute("author",authorRepository.findAll());
        return "authors";
    }
}
