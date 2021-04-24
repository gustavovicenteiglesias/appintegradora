package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAsistenciaIngresante;



	private byte habilitado;

	private byte presente;

	//bi-directional many-to-one association to Fechaingresoingresante
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_fecha_ingresante")
	@JsonBackReference(value="asistencia-fechaingresoingresante")
	private Fechaingresoingresante fechaingresoingresante;

	//bi-directional many-to-one association to Horariosactividad
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_horario_actividad")
	@JsonBackReference(value="asistencia-horariosactividad")
	private Horariosactividad horariosactividad;

	public Asistenciaingresante() {
	}

	public Integer getIdAsistenciaIngresante() {
		return idAsistenciaIngresante;
	}

	public void setIdAsistenciaIngresante(Integer idAsistenciaIngresante) {
		this.idAsistenciaIngresante = idAsistenciaIngresante;
	}

	public byte getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(byte habilitado) {
		this.habilitado = habilitado;
	}

	public byte getPresente() {
		return presente;
	}

	public void setPresente(byte presente) {
		this.presente = presente;
	}
	
	public Fechaingresoingresante getFechaingresoingresante() {
		return fechaingresoingresante;
	}

	public void setFechaingresoingresante(Fechaingresoingresante fechaingresoingresante) {
		this.fechaingresoingresante = fechaingresoingresante;
	}
	
	public Horariosactividad getHorariosactividad() {
		return horariosactividad;
	}

	public void setHorariosactividad(Horariosactividad horariosactividad) {
		this.horariosactividad = horariosactividad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}