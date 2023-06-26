package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Celular;
import com.example.demo.service.CelularService;

@SpringBootApplication
public class Pa2U2P4AtLvApplication implements CommandLineRunner {
	
	@Autowired
	private CelularService celularService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*Celular celu1= new Celular();
		celu1.setMarca("Samsung");
		celu1.setModelo("A10");
		celu1.setPrecio(new BigDecimal(100));
		this.celularService.guardar(celu1);
		
		Celular celu2= new Celular();
		celu2.setMarca("Samsung");
		celu2.setModelo("A20");
		celu2.setPrecio(new BigDecimal(180));
		this.celularService.guardar(celu2);
		
		Celular celu3= new Celular();
		celu3.setMarca("Samsung");
		celu3.setModelo("A50");
		celu3.setPrecio(new BigDecimal(300));
		this.celularService.guardar(celu3);
		
		Celular celu4= new Celular();
		celu4.setMarca("Huawei");
		celu4.setModelo("Y9");
		celu4.setPrecio(new BigDecimal(200));
		this.celularService.guardar(celu4);
		
		Celular celu5= new Celular();
		celu5.setMarca("LG");
		celu5.setModelo("LG Wing");
		celu5.setPrecio(new BigDecimal(600));
		this.celularService.guardar(celu5);*/
		
		System.out.println("Query con single result");
		System.out.println(this.celularService.buscarPorModelo("A10"));
		
		System.out.println("Query con result list");
		System.out.println(this.celularService.buscarPorMarca("Samsung"));
		
		System.out.println("Query con 2 atributos");
		System.out.println(this.celularService.buscarPorMarcayPrecio("Samsung", new BigDecimal(180)));
		
		System.out.println("TypedQuery con single result");
		System.out.println(this.celularService.buscarPorModeloTyped("A10"));
		
		System.out.println("TypedQuery con result list");
		System.out.println(this.celularService.buscarPorMarcaTyped("Samsung"));
		

		
		
		
		
		
	
	
		
			
	}

}
