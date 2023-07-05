package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	public void guardar(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);
		
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepository.actualizar(estudiante);
		
	}

	@Override
	public void buscar(String cedula) {
		this.estudianteRepository.seleccionar(cedula);
		
	}

	@Override
	public void eliminar(String cedula) {
		this.estudianteRepository.eliminar(cedula);
		
	}

	@Override
	public Estudiante buscarPorApellido(String apellido) {
		
		return this.estudianteRepository.seleccionarPorApellido(apellido);
	}

	@Override
	public List<Estudiante> generarReporte(String apellido) {
		
		return this.estudianteRepository.seleccionarListaPorApellido(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoyNombre(String apellido, String nombre) {
		
		return this.estudianteRepository.seleccionarPorApellidoyNombre(apellido, nombre);
	}

	@Override
	public Estudiante buscarPorApellidoTyped(String apellido) {
		
		return this.estudianteRepository.seleccionarPorApellidoTyped(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoNamed(String apellido) {
		
		return this.estudianteRepository.seleccionarPorApellidoNamed(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoNamedQuery(String apellido) {
		
		return this.estudianteRepository.seleccionarPorApellidoNamedQuery(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoNative(String apellido) {
		
		return this.estudianteRepository.seleccionarPorApellidoNative(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoNativeQueryNamed(String apellido) {
	
		return this.estudianteRepository.seleccionarPorApellidoNativeQueryNamed(apellido);
	}

	@Override
	public Estudiante buscarPorNombreNamedQuery(String nombre) {
		
		return this.estudianteRepository.seleccionarPorNombreNamedQuery(nombre);
	}

	@Override
	public Estudiante buscarPorNombreNativeQueryNamed(String nombre) {
		
		return this.estudianteRepository.seleccionarPorNombreNativeQueryNamed(nombre);
	}

	@Override
	public Estudiante buscarPorApellidoCriteriaApiQuery(String apellido) {
	
		return this.estudianteRepository.seleccionarPorApellidoCriteriaApiQuery(apellido);
	}

	@Override
	public Estudiante buscarEstudianteDinamico(String nombre, String apellido, Double peso) {
		
		return this.estudianteRepository.seleccionarEstudianteDinamico(nombre, apellido, peso);
	}

	@Override
	public int eliminarPorNombre(String nombre) {
		
		return this.estudianteRepository.eliminarPorNombre(nombre);
	}

	@Override
	public int actualizarPorApellido(String nombre, String apellido) {
		
		return this.estudianteRepository.actualizarPorApellido(nombre, apellido);
	}

}
