package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface HotelRepository {
	
	public void insertar(Hotel Hotel);
	public void actualizar(Hotel Hotel);
	public Hotel seleccionar(Integer id );
	public void eliminar(Integer id );
	
	public List<Habitacion> seleccionarHabitaciones(String nombrehotel);
	

}
