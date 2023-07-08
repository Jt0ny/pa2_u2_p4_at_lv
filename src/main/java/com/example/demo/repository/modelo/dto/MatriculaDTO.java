package com.example.demo.repository.modelo.dto;

import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Materia;

public class MatriculaDTO {
	
	
	private Alumno alumno;
	private Materia materia;
	
	public MatriculaDTO() {
		
	}
	
	public MatriculaDTO(Alumno alumno, Materia materia) {
		super();
		this.alumno = alumno;
		this.materia = materia;
	}

	//set y det
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "MatriculaDTO [alumno=" + alumno + ", materia=" + materia + "]";
	}


	
}
