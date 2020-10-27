package br.com.cursos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.cursos.model.Curso;
import br.com.cursos.repository.CursoRepository;

@Configuration
@Profile("dev")
public class CarregaBaseDeDados {

	@Autowired
	private CursoRepository repository;
	
	@Bean
	CommandLineRunner carregaBanco() {
		return args -> {
			Curso curso1 = new Curso("Curso de Java", 123.45);
			Curso curso2 = new Curso("Curso Design de Games", 130.99);
			
			repository.save(curso1);
			repository.save(curso2);
		};
	}
	
}
