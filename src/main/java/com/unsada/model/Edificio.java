package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the edificio database table.
 * 
 */
@Entity
@Table(name="edificio")
@NamedQuery(name="Edificio.findAll", query="SELECT e FROM Edificio e")
public class Edificio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEdificio;

	private String ciudad;

	private String direccion;

	private String nombre;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="edificioBean")
	@JsonIgnore
	private List<Aula> aulas;

	//bi-directional many-to-one association to Sede
	@ManyToOne(optional = false)
	@JsonBackReference
	private Sede sede;

	public Edificio() {
	}

	public int getIdEdificio() {
		return idEdificio;
	}

	public void setIdEdificio(int idEdificio) {
		this.idEdificio = idEdificio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}
	
	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}