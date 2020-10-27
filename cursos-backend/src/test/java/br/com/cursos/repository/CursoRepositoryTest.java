package br.com.cursos.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.cursos.model.Curso;

@SpringBootTest
public class CursoRepositoryTest {

	@Autowired
	private CursoRepository repository;

	@Test
	void findByNomeSimples() {
		List<Curso> cursos = repository.findByNome("Curso de Java");
		Assertions.assertThat(cursos).hasSize(1);
	}
	
	@Test
	void findByNomeLike() {
		List<Curso> cursos = repository.findByNomeLike("%Java");
		Assertions.assertThat(cursos).hasSize(1);
	}
	
	@Test
	void findByNomeLikeOrdenado() {
		List<Curso> cursos = repository.findByNomeLikeOrderByNome("Curso%");
		Assertions.assertThat(cursos).hasSize(2);
	}
	
}
