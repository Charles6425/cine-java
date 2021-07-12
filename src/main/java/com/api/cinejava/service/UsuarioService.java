package com.api.cinejava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.cinejava.model.FilmeModel;
import com.api.cinejava.model.UsuarioModel;
import com.api.cinejava.repository.UsuarioRepository;
import com.api.cinejava.service.exceptions.ObjectNotFoundExceptions;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		UsuarioModel usuarioModel = repository.findByLogin(login);
		if (usuarioModel == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		return usuarioModel;

	}

	public List<UsuarioModel> findAll() {
		return repository.findAll();
	}

	public UsuarioModel create(UsuarioModel obj) {
		obj.setId(null);
		obj.setSenha(BCryptPasswordEncoder(obj));
		return repository.save(obj);
	}

	private String BCryptPasswordEncoder(UsuarioModel obj) {
		String senha = new BCryptPasswordEncoder().encode(obj.getSenha());
		return senha;
	}

}
