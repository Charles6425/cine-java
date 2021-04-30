package com.api.cinejava.repository;

import com.api.cinejava.model.SessaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoModel, Integer> {
}
