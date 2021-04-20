package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;
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
	private int idAula;

	private String capacidad;

	private int capacidad;

	@Column(name="comision_idcomision")
	private int comisionIdcomision;

	private String direccion;

	private String edificio;

	@Column(name="id_aula")
	private int idAula;

	private String nombre;

	private String nombre;

	//bi-directional many-to-one association to Actividad
	@OneToMany(mappedBy="aula")
	private List<Actividad> actividads;

	//bi-directional many-to-one association to Edificio
	@ManyToOne
	@JoinColumn(name="idEdificio")
	private Edificio edificioBean;

	public Aula() {
	}

	public int getIdAula() {
		return this.idAula;
	}

	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}

	public String getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getComisionIdcomision() {
		return this.comisionIdcomision;
	}

	public void setComisionIdcomision(int comisionIdcomision) {
		this.comisionIdcomision = comisionIdcomision;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEdificio() {
		return this.edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public int getIdAula() {
		return this.idAula;
	}

	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Actividad> getActividads() {
		return this.actividads;
	}

	public void setActividads(List<Actividad> actividads) {
		this.actividads = actividads;
	}

	public Actividad addActividad(Actividad actividad) {
		getActividads().add(actividad);
		actividad.setAula(this);

		return actividad;
	}

	public Actividad removeActividad(Actividad actividad) {
		getActividads().remove(actividad);
		actividad.setAula(null);

		return actividad;
	}

	public Edificio getEdificioBean() {
		return this.edificioBean;
	}

	public void setEdificioBean(Edificio edificioBean) {
		this.edificioBean = edificioBean;
	}

}