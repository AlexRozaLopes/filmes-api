package com.example.filmesapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Filme {

    @Id
    private Long id;
    private String nome;
    private String genero;
    private String diretor;
    private String ano;
    private String sinopse;

}
