package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Celular;

public interface CelularService {
	
	public void guardar(Celular celular);
	public void actualizar(Celular celular);
	public Celular buscar (Integer id);
	public void eliminar (Integer id);
	
	public 	Celular buscarPorModelo(String modelo);
	
	public List<Celular> buscarPorMarca(String marca);
	
	public Celular buscarPorMarcayPrecio(String marca,BigDecimal precio);
	
	public Celular buscarPorModeloTyped(String modelo);
	
	public List<Celular> buscarPorMarcaTyped(String marca);
	

}
