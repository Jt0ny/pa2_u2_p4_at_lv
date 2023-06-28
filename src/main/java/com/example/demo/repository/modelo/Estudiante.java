package com.example.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="estudiante")
@Entity

@NamedQueries({@NamedQuery(name="Estudiante.buscaPorApellido",query="select e from Estudiante e where e.apellido = :datoApellido"),
				@NamedQuery(name="Estudiante.buscaPorNombre",query="select e from Estudiante e where e.nombre = :datoNombre")})


@NamedNativeQueries({@NamedNativeQuery(name="Estudiante.buscaPorApellidoNative",query="SELECT * FROM estudiante where estu_apellido =:datoApellido",resultClass = Estudiante.class),
					@NamedNativeQuery(name="Estudiante.buscaPorNombreNative",query="SELECT * FROM estudiante where estu_nombre =:datoNombre",resultClass = Estudiante.class)})


public class Estudiante {
	
	@GeneratedValue(generator ="seq_estudiante",strategy = GenerationType.SEQUENCE )
	@SequenceGenerator(name = "seq_estudiante",sequenceName = "seq_estudiante",allocationSize = 1)// el allocationSize de coincidir con el valor que pusimos en el incremento
	@Id// Hay que hacer un mapeo especifico
	@Column(name="estu_id")
	private Integer id;
	
	@Column(name="estu_cedula")
	private String cedula;
	
	@Column(name="estu_nombre")
	private String nombre;
	
	@Column(name="estu_apellido")
	private String apellido;
	
	

	//set y get
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + "]\n";
	}
	
}
