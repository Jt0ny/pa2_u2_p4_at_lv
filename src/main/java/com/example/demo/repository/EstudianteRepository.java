package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteRepository {
	
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante seleccionar(String cedula);
	public void eliminar(String cedula);
	
	public Estudiante seleccionarPorApellido(String apellido);
	public  List<Estudiante> seleccionarListaPorApellido(String apellido);
	
	public Estudiante seleccionarPorApellidoyNombre(String apellido,String nombre);
	
	public Estudiante seleccionarPorApellidoTyped(String apellido);
	
	public Estudiante seleccionarPorApellidoNamed(String apellido);
	
	public Estudiante seleccionarPorApellidoNamedQuery (String apellido);
	
	public Estudiante seleccionarPorNombreNamedQuery (String nombre);

	public Estudiante seleccionarPorApellidoNative(String apellido);
	
	public Estudiante seleccionarPorApellidoNativeQueryNamed(String apellido);
	
	public Estudiante seleccionarPorNombreNativeQueryNamed(String nombre);
	
	public Estudiante seleccionarPorApellidoCriteriaApiQuery(String apellido);

	public Estudiante seleccionarEstudianteDinamico(String nombre,String apellido,Double peso);

	public int eliminarPorNombre (String nombre);
	
	public int actualizarPorApellido(String nombre,String apellido);
}
