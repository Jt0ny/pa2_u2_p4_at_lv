package com.example.demo.service;

import com.example.demo.repository.modelo.Libro;

public interface LibroService {
	
	public void guardar(Libro libro);
	public void actualizar(Integer  id);
	public Libro buscar(Integer  id);
	public void eliminar(Integer  id);

}