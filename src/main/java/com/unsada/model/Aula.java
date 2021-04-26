package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the aula database table.
 * 
 */
@Entity
@Table(name="aula")
@NamedQuery(name="Aula.findAll", query="SELECT a FROM Aula a")
public class Aula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAula;
	private int capacidad;
	private String nombre;
	
	//bi-directional many-to-one association to Actividad
	@OneToMany(mappedBy="aula")
	private List<Actividad> actividads;

	//bi-directional many-to-one association to Edificio
	@ManyToOne(optional = true)
	@JoinColumn(name="edificio_idEdificio")
	private Edificio edificioBean;

	public Aula() {
	}

	public int getIdAula() {
		return idAula;
	}

	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@JsonManagedReference
	public List<Actividad> getActividads() {
		return actividads;
	}

	public void setActividads(List<Actividad> actividads) {
		this.actividads = actividads;
	}
	@JsonBackReference
	public Edificio getEdificioBean() {
		return edificioBean;
	}

	public void setEdificioBean(Edificio edificioBean) {
		this.edificioBean = edificioBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}