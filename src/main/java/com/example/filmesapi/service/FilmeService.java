package com.example.filmesapi.service;

import com.example.filmesapi.model.Filme;
import com.example.filmesapi.model.dto.FilmeDto;
import com.example.filmesapi.model.mapper.FilmeRepresentationModelAssembler;
import com.example.filmesapi.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class FilmeService {

    protected FilmeRepository filmeRepository;
    private final FilmeRepresentationModelAssembler filmeRepresentationModelAssembler;

    public Page<FilmeDto> getFilmes(Pageable pageable) {
        log.info("Buscando filmes");
        Page<Filme> filmes = filmeRepository.findAll(pageable);
        log.info("Filmes encontrados: {}", filmes.getTotalElements());
        return filmes.map(filmeRepresentationModelAssembler::toModel);
    }

    public PagedModel<EntityModel<FilmeDto>> getFilmesPaged(Pageable pageable) {
        log.info("Buscando filmes");
        Page<Filme> filmes = filmeRepository.findAll(pageable);
        log.info("Filmes encontrados: {}", filmes.getTotalElements());
        return filmeRepresentationModelAssembler.toPagedModel(filmes);
    }

    public FilmeDto getFilmeById(Long id) {
        log.info("Buscando filme com id: {}", id);
        return filmeRepository.findById(id)
                .map(filmeRepresentationModelAssembler::toModel)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }
}
