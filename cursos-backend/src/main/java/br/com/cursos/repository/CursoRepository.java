package br.com.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursos.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
