package br.com.angular.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.angular.model.Usuario;
import br.com.angular.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/autenticar", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public LoginResponse autenticar(@RequestBody Usuario usuario) throws ServletException {

		if(usuario.getNome()==null || usuario.getSenha()==null) {
			throw new ServletException("Nome é senhas obrigaorio.");
		}

		Usuario usuAutenticado = usuarioService.buscarPorNome(usuario.getNome());

		if(usuAutenticado==null) {
			throw new ServletException("Ususario nao encontrado");
		}
		
		if(usuAutenticado.getSenha().equals(usuario.getSenha())) {
			throw new ServletException("Usuario ou senha invalido");
		}
		
		String token = Jwts.builder()
		.setSubject(usuAutenticado.getNome())
		.signWith(SignatureAlgorithm.HS512,"banana")
		.setExpiration(new Date(System.currentTimeMillis()+1*60*1000))
		.compact();
		return new LoginResponse(token);
	}

	private class LoginResponse {
		public String token;

		public LoginResponse(String token) {
			this.token = token;
		}
//		public String getToken() {
//			return token;
//		}

	}
}
