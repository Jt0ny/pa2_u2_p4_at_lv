package com.example.demo.service;

import com.example.demo.repository.modelo.Empleado;

public interface EmpleadoService {
	
	public void guardar(Empleado empleado);
	public void actualizar(Empleado empleado);
	public void buscar(String cedula);
	public void eliminar(String cedula);

}
