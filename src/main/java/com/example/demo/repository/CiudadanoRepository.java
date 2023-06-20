package com.example.demo.repository;

import com.example.demo.repository.modelo.Ciudadano;

public interface CiudadanoRepository {

	public void insertar(Ciudadano ciudadano);
	public void actualizar(Ciudadano cuidadano);
	public Ciudadano seleccionar(String cedula);
	public void eliminar(String cedula);
	
}
