package com.api.cinejava.repository;

import com.api.cinejava.model.SessaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoModel, Integer> {
    @Query("SELECT obj FROM sessao obj where obj.salaModel.id = :id_ses")
    List<SessaoModel> findAllByCategoria(@Param(value = "id_ses")  Integer id_ses);
}
