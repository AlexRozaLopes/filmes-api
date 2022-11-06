package com.example.filmesapi.repository;

import com.example.filmesapi.model.Filme;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends PagingAndSortingRepository<Filme, Long> {

}
