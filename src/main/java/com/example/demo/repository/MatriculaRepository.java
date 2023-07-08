package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

public interface MatriculaRepository {
	
	public void  insertar(Matricula matricula,Alumno alumno, Materia materia);
	 
	public List<MatriculaDTO> seleccionarTodosDTO();

}
