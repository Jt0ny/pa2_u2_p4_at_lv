package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U2P4AtLvApplication implements CommandLineRunner {
	
	@Autowired
	private MatriculaService  matriculaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Alumno alumno1= new Alumno ();
		alumno1.setNombre("Anthony");
		
		Materia materia1 = new Materia ();
		materia1.setNombre("Matematicas");
		
		Matricula matricula1= new Matricula();
		matricula1.setAlumno(alumno1);
		matricula1.setMateria(materia1);
		matricula1.setNumero("2");
		matricula1.setFecha(LocalDateTime.now());
		this.matriculaService.guardar(matricula1, alumno1, materia1);
		
		
	
		
			
	}

}
