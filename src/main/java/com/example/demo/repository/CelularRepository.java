package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Celular;

public interface CelularRepository {
	
	public void insertar (Celular celular);
	public void actulizar(Celular celular);
	public Celular seleccionar (Integer id);
	public void eliminar (Integer id);
	
	public 	Celular seleccionarPorModelo(String modelo);
	
	public List<Celular> seleccionarPorMarca(String marca);
	
	public Celular seleccionarPorMarcayPrecio(String marca,BigDecimal precio);
	
	public Celular seleccionarPorModeloTyped(String modelo);
	
	public List<Celular> seleccionarPorMarcaTyped(String marca);

}
