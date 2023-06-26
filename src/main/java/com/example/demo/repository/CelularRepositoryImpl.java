package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Celular;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CelularRepositoryImpl  implements CelularRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Celular celular) {
		this.entityManager.persist(celular);
	}

	@Override
	public void actulizar(Celular celular) {
		this.entityManager.merge(celular);
	}

	@Override
	public Celular seleccionar(Integer id) {
		
		return this.entityManager.find(Celular.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		Celular celu= this.seleccionar(id);
		this.entityManager.remove(celu);	
	}

	// Querys
	@Override
	public Celular seleccionarPorModelo(String modelo) {
		Query myQuery = this.entityManager.createQuery("select e from Celular e where e.modelo = :datoModelo");
		myQuery.setParameter("datoModelo", modelo);
		return (Celular) myQuery.getSingleResult();
	}

	@Override
	public List<Celular> seleccionarPorMarca(String marca) {
		Query myQuery=this.entityManager.createQuery("select e from Celular e where e.marca = :datoMarca");
		myQuery.setParameter("datoMarca",marca);
		return myQuery.getResultList();
	}

	@Override
	public Celular seleccionarPorMarcayPrecio(String marca, BigDecimal precio) {
		Query myQuery=this.entityManager.createQuery("select e from Celular e where e.marca = :datoMarca and e.precio=:datoPrecio");
		myQuery.setParameter("datoMarca",marca);
		myQuery.setParameter("datoPrecio",precio);
		return (Celular) myQuery.getSingleResult();
	}

	@Override
	public Celular seleccionarPorModeloTyped(String modelo) {
		TypedQuery<Celular> myQuery=this.entityManager.createQuery("select e from Celular e where e.modelo = :datoModelo",Celular.class);
		myQuery.setParameter("datoModelo", modelo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Celular> seleccionarPorMarcaTyped(String marca) {
		Query myQuery=this.entityManager.createQuery("select e from Celular e where e.marca = :datoMarca",Celular.class);
		myQuery.setParameter("datoMarca",marca);
		return myQuery.getResultList();
	}

}
