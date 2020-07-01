package pl.baksza.praca_domowa_t6;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class FilmAspectService {

//    @Before("execution(void pl.baksza.praca_domowa_t6.Service.FilmService.addFilmToMyList())")
//    private void beforeAddFilm() {
//        System.out.println("BEFORE SEND EMAIL");
//    }

//    @After("execution(void pl.baksza.praca_domowa_t6.Service.FilmService.addFilmToMyList())")
    // @Around("@annotation(HelloAspectAnnotation)")

    @After("@annotation(FilmAspectService)")
    private void afterAddFilm() {
        System.out.println("AFTER SEND EMAIL");
    }

//    @Before("execution(* pl.baksza.praca_domowa_t6.Hello())")
//    private void beforeHello() {
//        System.out.println("BEFORE HELLO");
//    }
//
//    @After("execution(* pl.baksza.praca_domowa_t6.Hello())")
//    private void afterHello() {
//        System.out.println("AFTER HELLO");
//    }
}
