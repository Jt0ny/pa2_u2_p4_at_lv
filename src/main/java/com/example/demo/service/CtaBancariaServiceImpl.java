package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CtaBancariaRepository;
import com.example.demo.repository.modelo.CtaBancaria;
@Service
public class CtaBancariaServiceImpl implements CtaBancariaService {

	@Autowired
	private CtaBancariaRepository bancariaRepository;
	
	@Override
	public void aperturar(CtaBancaria ctaBancaria) {
	this.bancariaRepository.insertar(ctaBancaria);
	
	LocalDate fecha = LocalDate.now();
	int dia = fecha.getDayOfMonth();

    if (dia % 2 == 0) {
        System.out.println("El día es par");
        BigDecimal comision =ctaBancaria.getSaldo().multiply(new BigDecimal(1.05));
        ctaBancaria.setSaldo(comision);
      
    } else {
        System.out.println("El día es impar no se subira nada");
    }
		
	}

	@Override
	public void actualizar(CtaBancaria ctaBancaria) {
		
		this.bancariaRepository.actualizar(ctaBancaria);
	}

	@Override
	public void consultar(String cedula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		
	}

}
