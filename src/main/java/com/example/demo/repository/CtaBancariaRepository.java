package com.example.demo.repository;

import com.example.demo.repository.modelo.CtaBancaria;

public interface CtaBancariaRepository {

	public void insertar(CtaBancaria ctaBancaria);
	public void actualizar(CtaBancaria ctaBancaria);
	public CtaBancaria seleccionar(String cedula);
	public void eliminar(String cedula);
}
