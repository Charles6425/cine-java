package com.api.cinejava.repository;

import com.api.cinejava.model.SalaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<SalaModel, Integer> {
}
