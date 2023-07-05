package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import ch.qos.logback.core.joran.conditional.Condition;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);//para agregar, y recibe un entity que ya se hizo en el mapeo de la clase estudiante
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);//para actualizar
		
	}

	@Override
	public Estudiante seleccionar(String cedula) {
		
		 return this.entityManager.find(Estudiante.class, cedula);//realiza la busqueda
	}

	@Override
	public void eliminar(String cedula) {
		Estudiante estu=this.seleccionar(cedula);
		this.entityManager.remove(estu);
	
	}
//QUERY JPQL
	@Override
	public Estudiante seleccionarPorApellido(String apellido) {
		//SQL
		//select * from estudiante e where e.estu_apellido = 
		//JPQL
		//select e from Estudiante e where e.apellido = 
		Query myQuery=this.entityManager.createQuery("select e from Estudiante e where e.apellido = :datoApellido");// el de los 2 puntos es un atributo 
		myQuery.setParameter("datoApellido",apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> seleccionarListaPorApellido(String apellido) {
		Query myQuery=this.entityManager.createQuery("select e from Estudiante e where e.apellido = :datoApellido");// el de los 2 puntos es un atributo 
		myQuery.setParameter("datoApellido",apellido);
		return myQuery.getResultList();
	}

	@Override
	public Estudiante seleccionarPorApellidoyNombre(String apellido, String nombre) {
		Query myQuery=this.entityManager.createQuery("select e from Estudiante e where e.apellido = :datoApellido and e.nombre=:datoNombre");// el de los 2 puntos es un atributo 
		myQuery.setParameter("datoApellido",apellido);
		myQuery.setParameter("datoNombre",nombre);
		return (Estudiante) myQuery.getSingleResult();
	
	}
//TypedQuery
	@Override
	public Estudiante seleccionarPorApellidoTyped(String apellido) {
		TypedQuery<Estudiante> myQuery=this.entityManager.createQuery("select e from Estudiante e where e.apellido = :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido",apellido);
		return myQuery.getSingleResult();// aqui no pide el cast
	}

	@Override
	public Estudiante seleccionarPorApellidoNamed(String apellido) {
		TypedQuery<Estudiante> myQuery=	this.entityManager.createNamedQuery("Estudiante.buscaPorApellido",Estudiante.class);
		myQuery.setParameter("datoApellido",apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNamedQuery(String apellido) {
		Query myQuery=	this.entityManager.createNamedQuery("Estudiante.buscaPorApellido");
		myQuery.setParameter("datoApellido",apellido);
		return (Estudiante) myQuery.getSingleResult();
	}
// Native query
	@Override
	public Estudiante seleccionarPorApellidoNative(String apellido) {
		Query myQuery=this.entityManager.createNativeQuery("SELECT * FROM estudiante where estu_apellido =:datoApellido",Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoNativeQueryNamed(String apellido) {
		TypedQuery<Estudiante> myQuery=this.entityManager.createNamedQuery("Estudiante.buscaPorApellidoNative",Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

	//////
	@Override
	public Estudiante seleccionarPorNombreNamedQuery(String nombre) {
		Query myQuery=	this.entityManager.createNamedQuery("Estudiante.buscaPorNombre");
		myQuery.setParameter("datoNombre",nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorNombreNativeQueryNamed(String nombre) {
		TypedQuery<Estudiante> myQuery=this.entityManager.createNamedQuery("Estudiante.buscaPorNombreNative",Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

	//Criteria api query
	
	@Override
	public Estudiante seleccionarPorApellidoCriteriaApiQuery(String apellido) {
		CriteriaBuilder myBuilder=this.entityManager.getCriteriaBuilder();
		//1.Especificar el tipo de retorno que tiene la query
		CriteriaQuery<Estudiante> myCriteriaQuery=myBuilder.createQuery(Estudiante.class);
		
		//2.Empezamos a crear el sql
		//2.1 Definimos el from(Root)el from se le conoce como root
		Root<Estudiante> miTablaFrom=myCriteriaQuery.from(Estudiante.class);//From estudiante
		
		//3. Construir las condiciones de mi sql (Las conodiciones se les conoce como predicados)
		//e.apellido=datoApellido
		Predicate condicionApellido= myBuilder.equal(miTablaFrom.get("datoApellido"), apellido);
		
		//4.Armamos mi sql final 
		myCriteriaQuery.select(miTablaFrom).where(condicionApellido);
		
		//5.Ejecucion de Query lo realizamos con TypedQuery 
		TypedQuery<Estudiante>myQueryFinal=this.entityManager.createQuery(myCriteriaQuery);
		
		
		return myQueryFinal.getSingleResult();
	}

	@Override
	public Estudiante seleccionarEstudianteDinamico(String nombre, String apellido, Double peso) {
		CriteriaBuilder myBuilder=this.entityManager.getCriteriaBuilder();
		//1.Especificar el tipo de retorno que tiene la query
		CriteriaQuery<Estudiante> myCriteriaQuery=myBuilder.createQuery(Estudiante.class);
		
		//2.Empezamos a crear el sql
		//2.1 Definimos el from(Root)el from se le conoce como root
		Root<Estudiante> miTablaFrom=myCriteriaQuery.from(Estudiante.class);//From estudiante
		
		//3. Construir las condiciones de mi sql (Las conodiciones se les conoce como predicados)
		//peso >100 e.nombre=.... and e.apeliido=...
		//peso <=100 e.nombre= OR e.apellido=?
		
		//e.nombre
		Predicate pNombre=myBuilder.equal(miTablaFrom.get("nombre"), nombre);
		
		//e.apellido
		Predicate pApellido=myBuilder.equal(miTablaFrom.get("apellido"), apellido);
		
		Predicate predicadoFinal=null;
		if(peso.compareTo(Double.valueOf(100))<=0) {
			predicadoFinal=myBuilder.or(pNombre,pApellido);
		}else {
			predicadoFinal=myBuilder.and(pNombre,pApellido);
		}
		//4.Armamos mi sql final 
		myCriteriaQuery.select(miTablaFrom).where(predicadoFinal);
				
		//5.Ejecucion de Query lo realizamos con TypedQuery 
		TypedQuery<Estudiante>myQueryFinal=this.entityManager.createQuery(myCriteriaQuery);
				
				
				return myQueryFinal.getSingleResult();
	}

	@Override
	public int eliminarPorNombre(String nombre) {
		// DELETE FROM estudiante WHERE estu_nombre=?
		//delete from Estudiante e where e.nombre=:datoNombre
		Query myQuery=this.entityManager.createQuery("DELETE FROM Estudiante e where e.nombre= :datoNombre");
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.executeUpdate();
		
	}

	@Override
	public int actualizarPorApellido(String nombre,String apellido) {
		//SQL
		//UPDATE estudiante SET estu_apellido=? WHERE estu_apellido=?
		//JPQL
		//UPDATE Estudiante e SET e.nombre=:datoNombre WHERE e.apellido=:datoApellido
		Query myQuery=this.entityManager.createQuery("UPDATE Estudiante e SET e.nombre=:datoNombre WHERE e.apellido=:datoApellido");
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.executeUpdate();

	}
	
	

}