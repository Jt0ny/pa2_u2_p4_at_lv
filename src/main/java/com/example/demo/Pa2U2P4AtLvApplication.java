package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U2P4AtLvApplication implements CommandLineRunner {
	
	@Autowired
	private EstudianteService  estudianteService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*Estudiante estu= new Estudiante();
		estu.setApellido("Valladares");
		estu.setCedula("1564651313");
		estu.setNombre("Luis");
		this.estudianteService.guardar(estu);*/
		
		System.out.println(this.estudianteService.buscarPorApellido("Valladares"));
		System.out.println(this.estudianteService.generarReporte("Tipan"));
		
		System.out.println(this.estudianteService.buscarPorApellidoyNombre("Valladares","Luis"));
		
		this.estudianteService.buscarPorApellidoTyped("Valladares");
		
	
	
		
			
	}

}
