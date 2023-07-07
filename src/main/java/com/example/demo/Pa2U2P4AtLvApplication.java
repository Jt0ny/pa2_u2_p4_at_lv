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
		
		
		Celular c1= new Celular ();
		c1.setMarca("Samsung");
		c1.setModelo("A10");
		c1.setPrecio(new BigDecimal(90));
		this.celularService.guardar(c1);
		
		Celular c2= new Celular ();
		c2.setMarca("Samsung");
		c2.setModelo("S23 ultra");
		c2.setPrecio(new BigDecimal(230));
		this.celularService.guardar(c2);
		
		Celular c3= new Celular ();
		c3.setMarca("Huawei");
		c3.setModelo("Y9");
		c3.setPrecio(new BigDecimal(150));
		this.celularService.guardar(c3);
		
		Celular c4= new Celular ();
		c4.setMarca("Huawei");
		c4.setModelo("P20 lite");
		c4.setPrecio(new BigDecimal(200));
		this.celularService.guardar(c4);
		
		Celular c5= new Celular ();
		c5.setMarca("Xiaomi");
		c5.setModelo("Redmi");
		c5.setPrecio(new BigDecimal(390));
		this.celularService.guardar(c5);
		
		System.out.println(this.celularService.buscarCelularDinamico("Samsung", new BigDecimal(100), "Redmi"));
		
		


		
		
		
		
		
	
	
		
			
	}

}
