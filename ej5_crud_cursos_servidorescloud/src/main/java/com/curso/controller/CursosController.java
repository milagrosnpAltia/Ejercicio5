package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

@CrossOrigin("*")
@RestController
public class CursosController {
	@Value("${eureka.instance.instance-id}")
	String instancia;
	@Autowired
	CursosService service;
	
	@GetMapping(value="ver", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> verCursos(){
		System.out.println(instancia);
		return service.obtenerCursos();
	}
	
	@GetMapping(value="ver/{codigo}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso verCurso(@PathVariable("codigo") String codigo) {
		System.out.println(instancia);
		return service.infoCurso(codigo);
	}
	
	@GetMapping(value="ver/{pMin}/{pMax}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> verCursosPorPrecio(@PathVariable("pMin") double pMin, @PathVariable("pMax") double pMax){
		System.out.println(instancia);
		return service.obtenerCursosPorPrecio(pMin, pMax);
	}
	
	@PostMapping(value="agregar", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> agregarCurso(@RequestBody Curso curso){
		System.out.println(instancia);
		return service.altaCurso(curso);
	}
	
	@PutMapping(value="actualizar/{codigo}/{horas}")
	public void actualizarDuracionCurso(@PathVariable("codigo") String codigo, @PathVariable("horas") int horas) {
		System.out.println(instancia);
		service.modificarCurso(codigo, horas);
	}
	
	@DeleteMapping(value="eliminar/{codigo}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminarCurso(@PathVariable("codigo") String codigo){
		System.out.println(instancia);
		return service.borrarCurso(codigo);
	}
	
}
