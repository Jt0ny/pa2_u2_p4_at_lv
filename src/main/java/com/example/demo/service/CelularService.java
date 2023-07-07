package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Celular;

public interface CelularService {
	
	public void guardar(Celular celular);
	public void actualizar(Celular celular);
	public Celular buscar (Integer id);
	public void eliminar (Integer id);
	
	public List<Celular>buscarCelularDinamico(String marca,BigDecimal precio, String modelo);
	

}
