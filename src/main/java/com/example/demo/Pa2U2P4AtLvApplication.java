package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Celular;
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
		
		
		/*System.out.println("Named");
		this.estudianteService.buscarPorApellidoNamed("Valladares");
		
		System.out.println("NamedQuery");
		this.estudianteService.buscarPorApellidoNamedQuery("Valladares");
		

		System.out.println("Native");
		this.estudianteService.buscarPorApellidoNative("Valladares");*/
		
		System.out.println("NativeNamed");
		this.estudianteService.buscarPorApellidoNativeQueryNamed("Valladares");
		
		System.out.println("Por nombre");
		this.estudianteService.buscarPorNombreNamedQuery("Luis");
		this.estudianteService.buscarPorNombreNativeQueryNamed("Luis");


		
		
		
		
		
	
	
		
			
	}

}
