package br.com.cursos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursos.model.Curso;
import br.com.cursos.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping
	public List<Curso> todos(Curso filtro) {
		return cursoService.filtraPor(filtro);
	}

	@GetMapping("/{id}")
	public Curso getCurso(@PathVariable Integer id) {
		return cursoService.getCurso(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Curso salvar(@Valid @RequestBody Curso curso) {
		return cursoService.salvar(curso);
	}

	@PutMapping("/{id}")
	public Curso alterar(@PathVariable Integer id, @RequestBody Curso curso) {
		return cursoService.alterar(id, curso);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Integer id) {
		cursoService.excluir(id);
	}

}
