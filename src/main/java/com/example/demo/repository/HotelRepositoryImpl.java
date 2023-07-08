package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class HotelRepositoryImpl implements HotelRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Hotel Hotel) {
		this.entityManager.persist(Hotel);
		
	}

	@Override
	public void actualizar(Hotel Hotel) {
		this.entityManager.merge(Hotel);
		
	}

	@Override
	public Hotel seleccionar(Integer id ) {
	
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void eliminar(Integer id ) {
		Hotel hote = this.seleccionar(id);
		this.entityManager.remove(hote);
		
	}

	@Override
	public List<Habitacion> seleccionarHabitaciones(String nombrehotel) {
		
	Query myQuery=this.entityManager.createQuery("select e from Hotel.habitacion e where e.nombre = :datoNombre");// el de los 2 puntos es un atributo

    myQuery.setParameter("datoNombre",nombrehotel);

     	return myQuery.getResultList();
      
		
	}

}
