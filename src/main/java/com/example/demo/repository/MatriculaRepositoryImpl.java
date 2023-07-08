package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.EstudianteDTO;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements MatriculaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Matricula matricula,Alumno alumno,Materia materia) {
		this.entityManager.persist(matricula);
		this.entityManager.persist(alumno);
		this.entityManager.persist(materia);
		
	}

	@Override
	public List<MatriculaDTO> seleccionarTodosDTO() {
		TypedQuery<MatriculaDTO> myQuery= this.entityManager.createQuery("SELECT NEW com.example.demo.repository.modelo.dto.MatriculaDTO(e.alumno,e.materia) FROM Matricula e",MatriculaDTO.class);
		return myQuery.getResultList();
		
	}
	

}
