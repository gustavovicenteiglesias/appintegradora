package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the horasactividad_fechas database table.
 * 
 */
@Entity
@Table(name="horasactividad_fechas")
@NamedQuery(name="HorasactividadFecha.findAll", query="SELECT h FROM HorasactividadFecha h")
public class HorasactividadFecha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_horas")
	private int idHoras;

	@Column(name="hora_inicio")
	private Time horaInicio;

	@Column(name="horasactividad_fechascol")
	private Time horasactividadFechascol;

	//bi-directional many-to-one association to Horariosactividad
	@OneToMany(mappedBy="horasactividadFecha")
	
	@JsonBackReference("horarios-hora")
	private List<Horariosactividad> horariosactividads;

	public HorasactividadFecha() {
	}

	public int getIdHoras() {
		return this.idHoras;
	}

	public void setIdHoras(int idHoras) {
		this.idHoras = idHoras;
	}

	public Time getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHorasactividadFechascol() {
		return this.horasactividadFechascol;
	}

	public void setHorasactividadFechascol(Time horasactividadFechascol) {
		this.horasactividadFechascol = horasactividadFechascol;
	}

	public List<Horariosactividad> getHorariosactividads() {
		return this.horariosactividads;
	}

	public void setHorariosactividads(List<Horariosactividad> horariosactividads) {
		this.horariosactividads = horariosactividads;
	}

	public Horariosactividad addHorariosactividad(Horariosactividad horariosactividad) {
		getHorariosactividads().add(horariosactividad);
		horariosactividad.setHorasactividadFecha(this);

		return horariosactividad;
	}

	public Horariosactividad HorariosactividadremoveHorariosactividad(Horariosactividad horariosactividad) {
		getHorariosactividads().remove(horariosactividad);
		horariosactividad.setHorasactividadFecha(null);

		return horariosactividad;
	}

}