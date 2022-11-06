package com.example.filmesapi.controller;

import com.example.filmesapi.model.dto.FilmeDto;
import com.example.filmesapi.service.FilmeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
@AllArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @GetMapping
    public ResponseEntity<Page<FilmeDto>> getFilmes(Pageable pageable) {
        return ResponseEntity.ok(filmeService.getFilmes(pageable));
    }

    @GetMapping("/teste")
    public PagedModel<EntityModel<FilmeDto>> getFilmesPaged(Pageable pageable) {
        return filmeService.getFilmesPaged(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeDto> getFilmeById(@PathVariable Long id) {
        return ResponseEntity.ok(filmeService.getFilmeById(id));
    }
}
