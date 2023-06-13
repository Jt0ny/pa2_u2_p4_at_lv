package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CtaBancaria;
import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CtaBancariaRepositoryImpl implements CtaBancariaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertar(CtaBancaria ctaBancaria) {
		this.entityManager.persist(ctaBancaria);
		
	}

	@Override
	public void actualizar(CtaBancaria ctaBancaria) {
		this.entityManager.merge(ctaBancaria);
		
	}

	@Override
	public CtaBancaria seleccionar(String cedula) {
		 return this.entityManager.find(CtaBancaria.class, cedula);
	}

	@Override
	public void eliminar(String cedula) {
		CtaBancaria ctaB=this.seleccionar(cedula);
		this.entityManager.remove(ctaB);
		
	}

}
