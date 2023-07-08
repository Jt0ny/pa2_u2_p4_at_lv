package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.HotelService;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U2P4AtLvApplication implements CommandLineRunner {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private HotelService hotelService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		

		System.out.println(this.estudianteService.buscarTodosDTO());
		System.out.println(this.matriculaService.buscarTodosDTO());
		
		Hotel h1 =this.hotelService.buscar(5);
		System.out.println(h1.getNombre());
		
		//System.out.println(this.hotelService.seleccionarHabitaciones("Risol"));
		


		
		
		
		
		
	
	
		
			
	}

}
