package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

public interface MatriculaService {
	

	public void guardar (Matricula matricula,Alumno alumno, Materia materia);
	
	public List<MatriculaDTO> buscarTodosDTO();

}
