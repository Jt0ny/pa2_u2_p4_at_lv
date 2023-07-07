package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.repository.modelo.Celular;
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

	@Override
	public List<Celular> seleccionarCelularDinamico(String marca, BigDecimal precio, String modelo) {
	
		CriteriaBuilder myBuilder=this.entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Celular> myCriteriaQuery=myBuilder.createQuery(Celular.class);//Tipo de retorno
		
		Root<Celular> miTablaFrom=myCriteriaQuery.from(Celular.class);// definimos from celular
		
		//precio <=200 e.marca=.. or e.modelo
		//precio >200 e.marca and e.modelo
		
		//e.marca
		Predicate pMarca=myBuilder.equal(miTablaFrom.get("marca"), marca);
		
		//e.modelo
		Predicate pModelo=myBuilder.equal(miTablaFrom.get("modelo"), modelo);
		
		Predicate predicadoFinal=null;
		if(precio.compareTo(new BigDecimal(200))<0) {
			predicadoFinal=myBuilder.or(pMarca,pModelo);
		}else {
			predicadoFinal=myBuilder.and(pMarca,pModelo);
		}
		
		myCriteriaQuery.select(miTablaFrom).where(predicadoFinal);// SQL final
		TypedQuery<Celular>myQueryFinal=this.entityManager.createQuery(myCriteriaQuery);
		return  myQueryFinal.getResultList();
	}

	@Override
	public int eliminarPorModelo(String modelo) {
		
		Query myQuery=this.entityManager.createQuery("DELETE FROM Celular e where e.modelo= :datoModelo");
		myQuery.setParameter("datoModelo", modelo);
		return myQuery.executeUpdate();
		
	}

	@Override
	public int actualizarPorMarca(String marca, String marcaNueva) {
		
		Query myQuery=this.entityManager.createQuery("UPDATE Celular e SET e.marca=:datoNuevoM WHERE e.marca=:datoMarca");
		myQuery.setParameter("datoMarca", marca);
		myQuery.setParameter("datoNuevoM", marcaNueva);
		return myQuery.executeUpdate();
	}



}