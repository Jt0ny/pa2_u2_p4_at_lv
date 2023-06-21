package com.example.demo.repository;

import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;

public interface MatriculaRepository {
	
	public void  insertar(Matricula matricula,Alumno alumno, Materia materia);

}
