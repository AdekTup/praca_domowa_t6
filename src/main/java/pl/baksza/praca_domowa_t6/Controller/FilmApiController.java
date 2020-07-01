package pl.baksza.praca_domowa_t6.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.baksza.praca_domowa_t6.Model.FilmApi;
import pl.baksza.praca_domowa_t6.Service.FilmEmailService;
import pl.baksza.praca_domowa_t6.Service.FilmService;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class FilmApiController {
    public FilmService filmService;

    @Autowired
    public FilmApiController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/filmapi")
    public String getFilmApi(Model model) {
        List<FilmApi> filmApiList = filmService.getFilmApiList();
        model.addAttribute("filmApi", filmApiList.get(0));
        return "filmDataShow";
    }

    @GetMapping("/filmapilist")
    public String getFilmApiList(Model model) {
        FilmApi filmApi = new FilmApi();
        List<FilmApi> filmApiList = filmService.getFilmApiList();
        model.addAttribute("filmApiList", filmApiList);
        model.addAttribute("filmApi", filmApi);
        return "filmListBase";
    }


}
