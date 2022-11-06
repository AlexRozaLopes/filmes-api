package com.example.filmesapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmeDto extends RepresentationModel<FilmeDto> {

    private Long id;
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;
    @NotBlank(message = "O campo diretor é obrigatório")
    private String genero;
    @NotBlank(message = "O campo genero é obrigatório")
    private String diretor;
    @NotBlank(message = "O campo ano é obrigatório")
    private String ano;
    private String sinopse;

}
