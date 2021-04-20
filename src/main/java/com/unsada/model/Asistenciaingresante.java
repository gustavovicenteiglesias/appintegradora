package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the asistenciaingresante database table.
 * 
 */
@Entity
@Table(name="asistenciaingresante")
@NamedQuery(name="Asistenciaingresante.findAll", query="SELECT a FROM Asistenciaingresante a")
public class Asistenciaingresante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idAsistenciaIngresante;

	private byte habilitado;

	private byte presente;

	//bi-directional many-to-one association to Fechaingresoingresante
	@ManyToOne
	@JoinColumn(name="idFechaIngresante")
	private Fechaingresoingresante fechaingresoingresante;

	//bi-directional many-to-one association to Horariosactividad
	@ManyToOne
	@JoinColumn(name="idHorarioActividad")
	private Horariosactividad horariosactividad;

	public Asistenciaingresante() {
	}

	public String getIdAsistenciaIngresante() {
		return this.idAsistenciaIngresante;
	}

	public void setIdAsistenciaIngresante(String idAsistenciaIngresante) {
		this.idAsistenciaIngresante = idAsistenciaIngresante;
	}

	public byte getHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(byte habilitado) {
		this.habilitado = habilitado;
	}

	public byte getPresente() {
		return this.presente;
	}

	public void setPresente(byte presente) {
		this.presente = presente;
	}

	public Fechaingresoingresante getFechaingresoingresante() {
		return this.fechaingresoingresante;
	}

	public void setFechaingresoingresante(Fechaingresoingresante fechaingresoingresante) {
		this.fechaingresoingresante = fechaingresoingresante;
	}

	public Horariosactividad getHorariosactividad() {
		return this.horariosactividad;
	}

	public void setHorariosactividad(Horariosactividad horariosactividad) {
		this.horariosactividad = horariosactividad;
	}

}