package com.example.demo.service;

import com.example.demo.repository.modelo.Ciudadano;

public interface CuidadanoService {
	
	public void guardar(Ciudadano ciudadano);
	public void actualizar(Ciudadano ciudadano);
	public void buscar(String cedula);
	public void eliminar(String cedula);

}
