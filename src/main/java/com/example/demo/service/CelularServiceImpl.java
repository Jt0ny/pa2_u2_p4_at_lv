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

	@Override
	public List<Celular> buscarCelularDinamico(String marca, BigDecimal precio, String modelo) {
		
		return this.celularRepository.seleccionarCelularDinamico(marca, precio, modelo);
	}

	
	@Override
	public int borrarPorModelo(String modelo) {
		
		return this.celularRepository.eliminarPorModelo(modelo);
	}

	@Override
	public int actualizarPorMarca(String marca, String marcaNueva) {
		
		return this.celularRepository.actualizarPorMarca(marca, marcaNueva);
	}

	
}
