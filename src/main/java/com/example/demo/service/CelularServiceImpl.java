package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CelularRepository;
import com.example.demo.repository.modelo.Celular;

@Service
public class CelularServiceImpl implements CelularService {

	@Autowired
	private CelularRepository celularRepository ;
	
	@Override
	public void guardar(Celular celular) {
		this.celularRepository.insertar(celular);
		
	}

	@Override
	public void actualizar(Celular celular) {
		this.celularRepository.actulizar(celular);
		
	}

	@Override
	public Celular buscar(Integer id) {
		
		return this.celularRepository.seleccionar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.celularRepository.eliminar(id);
	}

	//Querys
	@Override
	public Celular buscarPorModelo(String modelo) {
		
		return this.celularRepository.seleccionarPorModelo(modelo);
	}

	@Override
	public List<Celular> buscarPorMarca(String marca) {
		
		return this.celularRepository.seleccionarPorMarca(marca);
	}

	@Override
	public Celular buscarPorMarcayPrecio(String marca, BigDecimal precio) {
	
		return this.celularRepository.seleccionarPorMarcayPrecio(marca, precio);
	}

	@Override
	public Celular buscarPorModeloTyped(String modelo) {
		
		return this.celularRepository.seleccionarPorModeloTyped(modelo);
	}

	@Override
	public List<Celular> buscarPorMarcaTyped(String marca) {
		
		return this.celularRepository.seleccionarPorMarcaTyped(marca);
	}

}
