package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Celular;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.CelularService;
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
		
		
		/*Estudiante estu1=new Estudiante();
		estu1.setApellido("Ramos");
		estu1.setNombre("Felipa");
		estu1.setPeso(78.0);
		estu1.setCedula("123");
		this.estudianteService.guardar(estu1);
		
		Estudiante estu2=new Estudiante();
		estu2.setApellido("Oña");
		estu2.setNombre("Omar");
		estu2.setPeso(120.0);
		estu2.setCedula("456");
		this.estudianteService.guardar(estu2);*/
		
		System.out.println(this.estudianteService.buscarEstudianteDinamico("Felipa", "Ramos", 78.0));

		System.out.println(this.estudianteService.eliminarPorNombre("Anthony"));

		System.out.println(this.estudianteService.actualizarPorApellido("Felipa", "Ramos"));


		
		
		
		
		
	
	
		
			
	}

}
