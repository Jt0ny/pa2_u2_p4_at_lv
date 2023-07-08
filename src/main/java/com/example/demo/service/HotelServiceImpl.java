package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	
	@Override
	public void guardar(Hotel hotel) {
	this.hotelRepository.insertar(hotel);
		
	}

	@Override
	public void actualizar(Hotel hotel) {
		this.hotelRepository.actualizar(hotel);
		
	}

	@Override
	public Hotel buscar(Integer id ) {
		 return this.hotelRepository.seleccionar(id);
	}

	@Override
	public void eliminar(Integer id ) {
		this.hotelRepository.eliminar(id);
		
	}

	@Override
	public List<Habitacion> seleccionarHabitaciones(String nombrehotel) {
		
		return this.hotelRepository.seleccionarHabitaciones(nombrehotel);
	}

}
