package br.com.angular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.angular.model.Usuario;
import br.com.angular.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario cadastrar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscarPorNome(String nome) {
		return usuarioRepository.buscarPorNome(nome);
	}

}
