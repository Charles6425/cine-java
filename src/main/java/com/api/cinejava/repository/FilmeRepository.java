package com.api.cinejava.repository;

import com.api.cinejava.model.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmeRepository extends JpaRepository<FilmeModel, Integer> {
}
