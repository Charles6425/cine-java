package com.api.cinejava.repository;


import com.api.cinejava.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, String> {
    UsuarioModel findByLogin(String login);
}
