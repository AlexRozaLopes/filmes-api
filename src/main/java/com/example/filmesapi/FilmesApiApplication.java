package com.example.filmesapi;

import com.example.filmesapi.model.Filme;
import com.example.filmesapi.repository.FilmeRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FilmesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmesApiApplication.class, args);
    }

    @Bean
    public ApplicationRunner addFilmes(FilmeRepository filmeRepository) {
        return args -> {
            filmeRepository.save(new Filme( 1L,"O Poderoso Chefão", "ação" ,"Francis Ford Coppola", "1972","primeiro filme"));
            filmeRepository.save(new Filme( 2L,"O Poderoso Chefão II", "ação" ,"Francis Ford Coppola", "1974","segundo filme"));
            filmeRepository.save(new Filme( 3L,"O Poderoso Chefão III", "ação" ,"Francis Ford Coppola", "1990","terceiro filme"));
            filmeRepository.save(new Filme( 4L,"O Poderoso Chefão IV", "ação" ,"Francis Ford Coppola", "2006","quarto filme"));
            filmeRepository.save(new Filme( 5L,"O Poderoso Chefão V", "ação" ,"Francis Ford Coppola", "2016","quinto filme"));
            filmeRepository.save(new Filme(6L,"Harry Potter e a Pedra Filosofal", "ação" ,"Chris Columbus", "2001","primeiro filme"));
            filmeRepository.save(new Filme(7L,"Harry Potter e a Câmara Secreta", "ação" ,"Chris Columbus", "2002","segundo filme"));
            filmeRepository.save(new Filme(8L,"Harry Potter e o Prisioneiro de Azkaban", "ação" ,"Alfonso Cuarón", "2004","terceiro filme"));
            filmeRepository.save(new Filme(9L,"Harry Potter e o Cálice de Fogo", "ação" ,"Mike Newell", "2005","quarto filme"));
            filmeRepository.save(new Filme(10L,"Harry Potter e a Ordem da Fênix", "ação" ,"David Yates", "2007","quinto filme"));
            filmeRepository.save(new Filme(11L,"Harry Potter e o Enigma do Príncipe", "ação" ,"David, Yates", "2009","sexto filme"));
            filmeRepository.save(new Filme(12L,"Harry Potter e as Relíquias da Morte - Parte 1", "ação" ,"David Yates", "2010","sétimo filme"));
            filmeRepository.save(new Filme(13L,"Harry Potter e as Relíquias da Morte - Parte 2", "ação" ,"David Yates", "2011","oitavo filme"));
        };
    }
}
