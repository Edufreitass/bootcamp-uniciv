package br.com.cursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cursos.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

	// Convensão da JPA
	List<Curso> findByNome(String nome);
	
	List<Curso> findByNomeLike(String nome);
	
	List<Curso> findByNomeLikeOrderByNomeAscPrecoDesc(String nome);
	
	List<Curso> findByNomeAndPreco(String nome, Double preco);
	
	// JPQL
	@Query("SELECT c FROM Curso c WHERE c.nome = ?1")
	List<Curso> buscaPorNome(String nome);
	
	// Query NATIVA
	@Query(value = "SELECT * FROM curso WHERE nome = ?1", nativeQuery = true)
	List<Curso> buscaPorNomeNativo(String nome);
	
	List<Curso> filtraPorNome(String nome);
	
}
