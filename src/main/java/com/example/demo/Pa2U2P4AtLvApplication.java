package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U2P4AtLvApplication implements CommandLineRunner {
    
	@Autowired
	private EstudianteService estudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estudiante estu= new Estudiante();
		estu.setNombre("Anthony");
		estu.setApellido("Tipan");
		estu.setCedula("116546542");
		//this.estudianteService.guardar(estu);
		this.estudianteService.eliminar("116546542");
		this.estudianteService.buscar("11654654");
		Estudiante estu2= new Estudiante();
		estu2.setNombre("Luis");
		estu2.setApellido("Valladares");
		estu2.setCedula("17478956");
		this.estudianteService.actualizar(estu2);
		//System.out.println(estu);
		
	}

}
