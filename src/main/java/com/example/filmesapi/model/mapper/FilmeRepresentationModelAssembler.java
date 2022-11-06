package com.example.filmesapi.model.mapper;

import com.example.filmesapi.controller.FilmeController;
import com.example.filmesapi.model.Filme;
import com.example.filmesapi.model.dto.FilmeDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class FilmeRepresentationModelAssembler extends RepresentationModelAssemblerSupport<Filme, FilmeDto> {

    private final ModelMapper modelMapper;
    private final PagedResourcesAssembler<FilmeDto> pagedResourcesAssembler;

    public FilmeRepresentationModelAssembler(ModelMapper modelMapper, PagedResourcesAssembler<FilmeDto> pagedResourcesAssembler) {
        super(FilmeController.class, FilmeDto.class);
        this.modelMapper = modelMapper;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    public FilmeDto toModel(Filme filme) {
        FilmeDto filmeDto = modelMapper.map(filme, FilmeDto.class);
        filmeDto.add(linkTo(methodOn(FilmeController.class).getFilmeById(filme.getId())).withSelfRel());
        return filmeDto;
    }

    public PagedModel<EntityModel<FilmeDto>> toPagedModel(Page<Filme> filmes) {
        Page<FilmeDto> filmeDtos = filmes.map(this::toModel);
        return pagedResourcesAssembler.toModel(filmeDtos);
    }
}
