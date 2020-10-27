package br.com.cursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursos.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

	List<Curso> findByNome(String nome);
	
	List<Curso> findByNomeLike(String nome);
	
	List<Curso> findByNomeLikeOrderByNome(String nome);
	
}
