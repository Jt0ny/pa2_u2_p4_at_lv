package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;
 @Service
public class MatriculaServiceImpl implements MatriculaService {

	 
	@Autowired
	private MatriculaRepository matriculaRepository;
	@Override
	public void guardar(Matricula matricula,Alumno alumno, Materia materia) {
		this.matriculaRepository.insertar(matricula, alumno, materia);
		
	}
	@Override
	public List<MatriculaDTO> buscarTodosDTO() {
		
		return this.matriculaRepository.seleccionarTodosDTO();
	}

}
