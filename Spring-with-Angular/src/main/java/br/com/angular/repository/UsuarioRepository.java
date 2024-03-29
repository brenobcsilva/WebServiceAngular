package br.com.angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.angular.model.Usuario;

@Repository
public interface  UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value = "select u Usuario u where u.nome=:pnome")
	public Usuario buscarPorNome(@Param("pnome") String nome);
	
}
