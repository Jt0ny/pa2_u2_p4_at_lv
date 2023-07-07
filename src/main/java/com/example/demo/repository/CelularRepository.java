package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Celular;

public interface CelularRepository {
	
	public void insertar (Celular celular);
	public void actulizar(Celular celular);
	public Celular seleccionar (Integer id);
	public void eliminar (Integer id);
	
	public List<Celular> seleccionarCelularDinamico(String marca,BigDecimal precio, String modelo);
	

}
