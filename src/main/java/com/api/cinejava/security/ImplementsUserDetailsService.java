package com.api.cinejava.security;

import com.api.cinejava.model.UsuarioModel;
import com.api.cinejava.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ImplementsUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UsuarioModel usuario = repository.findByLogin(login);

        if(usuario==null){
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        return usuario;
    }
}
