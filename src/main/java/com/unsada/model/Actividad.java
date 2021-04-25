package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the actividad database table.
 * 
 */
@Entity
@Table(name="actividad")
@NamedQuery(name="Actividad.findAll", query="SELECT a FROM Actividad a")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idActividad;
	private String nombre;
	@Temporal(TemporalType.DATE)
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	//bi-directional many-to-one association to Aula
	@ManyToOne(optional = false)
	@JoinColumn(name = "idAula")
	private Aula aula;

	//bi-directional many-to-one association to Horariosactividad
	
	@OneToMany(mappedBy="actividad")
	private List<Horariosactividad> horariosactividads;

	public Actividad() {
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdActividad() {
		return this.idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	@JsonBackReference
	public Aula getAula() {
		return this.aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}
	@JsonManagedReference
	public List<Horariosactividad> getHorariosactividads() {
		return this.horariosactividads;
	}

	public void setHorariosactividads(List<Horariosactividad> horariosactividads) {
		this.horariosactividads = horariosactividads;
	}

	public Horariosactividad addHorariosactividad(Horariosactividad horariosactividad) {
		getHorariosactividads().add(horariosactividad);
		horariosactividad.setActividad(this);

		return horariosactividad;
	}

	public Horariosactividad removeHorariosactividad(Horariosactividad horariosactividad) {
		getHorariosactividads().remove(horariosactividad);
		horariosactividad.setActividad(null);

		return horariosactividad;
	}

}