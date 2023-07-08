package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface HotelService {
	
	public void guardar(Hotel hotel);
	public void actualizar(Hotel hotel);
	public Hotel buscar(Integer id );
	public void eliminar(Integer id );

	public List<Habitacion> seleccionarHabitaciones(String nombrehotel);
	
}
