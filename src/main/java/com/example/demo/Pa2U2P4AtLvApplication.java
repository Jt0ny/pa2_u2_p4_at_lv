package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CtaBancaria;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.CtaBancariaService;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U2P4AtLvApplication implements CommandLineRunner {
    
	@Autowired
	private CtaBancariaService ctaBancariaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*Estudiante estu= new Estudiante();
		estu.setNombre("Anthony");
		estu.setApellido("Tipan");
		estu.setCedula("116546542");
		this.estudianteService.guardar(estu);*/
		CtaBancaria cta1 = new CtaBancaria();
		cta1.setCedulaPropietario("123456789");
		cta1.setFechaApertura(LocalDate.now());
		cta1.setNumero("60601");
		cta1.setSaldo(new BigDecimal(100));
		cta1.setTipo("A");
		this.ctaBancariaService.aperturar(cta1);
		
		System.out.println(cta1);
		
	}

}
