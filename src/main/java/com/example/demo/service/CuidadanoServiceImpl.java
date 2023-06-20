package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CiudadanoRepository;
import com.example.demo.repository.modelo.Ciudadano;

@Service
public class CuidadanoServiceImpl implements CuidadanoService {

   @Autowired
   private CiudadanoRepository cuidadanoRepository;
	
	@Override
	public void guardar(Ciudadano ciudadano) {
		this.cuidadanoRepository.insertar(ciudadano);
		
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		this.cuidadanoRepository.actualizar(ciudadano);
		
	}

	@Override
	public void buscar(String cedula) {
		this.cuidadanoRepository.seleccionar(cedula);
		
	}

	@Override
	public void eliminar(String cedula) {
		this.cuidadanoRepository.eliminar(cedula);
		
	}

}
