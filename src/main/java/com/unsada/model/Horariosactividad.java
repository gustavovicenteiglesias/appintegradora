package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the horariosactividad database table.
 * 
 */
@Entity
@Table(name="horariosactividad")
@NamedQuery(name="Horariosactividad.findAll", query="SELECT h FROM Horariosactividad h")
public class Horariosactividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHorarioActividad;


	private Time horaFin;

	private Time horaInicio;

	

	@Column(name="Lunes")
	private byte lunes;

	@Column(name="Martes")
	private byte martes;

	@Column(name="Miercoles")
	private byte miercoles;

	@Column(name="Jueves")
	private byte jueves;

	@Column(name="Viernes")
	private byte viernes;

	@Column(name="Sabado")
	private byte sabado;

	@Column(name="Domingo")
	private byte domingo;

	
	

	//bi-directional many-to-one association to Asistenciaingresante
	
	@OneToMany(mappedBy="horariosactividad")
	private List<Asistenciaingresante> asistenciaingresantes;

	//bi-directional many-to-one association to Fecha
	
	@OneToMany(mappedBy="horariosactividad")
	private List<Fecha> fechas;

	//bi-directional many-to-one association to Actividad
	
	@ManyToOne
	private Actividad actividad;

	public Horariosactividad() {
	}

	public int getIdHorarioActividad() {
		return this.idHorarioActividad;
	}

	public void setIdHorarioActividad(int idHorarioActividad) {
		this.idHorarioActividad = idHorarioActividad;
	}

	public byte getDomingo() {
		return this.domingo;
	}

	public void setDomingo(byte domingo) {
		this.domingo = domingo;
	}

	public Time getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public Time getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public byte getJueves() {
		return this.jueves;
	}

	public void setJueves(byte jueves) {
		this.jueves = jueves;
	}

	public byte getLunes() {
		return this.lunes;
	}

	public void setLunes(byte lunes) {
		this.lunes = lunes;
	}

	public byte getMartes() {
		return this.martes;
	}

	public void setMartes(byte martes) {
		this.martes = martes;
	}

	public byte getMiercoles() {
		return this.miercoles;
	}

	public void setMiercoles(byte miercoles) {
		this.miercoles = miercoles;
	}

	public byte getSabado() {
		return this.sabado;
	}

	public void setSabado(byte sabado) {
		this.sabado = sabado;
	}

	public byte getViernes() {
		return this.viernes;
	}

	public void setViernes(byte viernes) {
		this.viernes = viernes;
	}
	@JsonManagedReference
	public List<Asistenciaingresante> getAsistenciaingresantes() {
		return this.asistenciaingresantes;
	}

	public void setAsistenciaingresantes(List<Asistenciaingresante> asistenciaingresantes) {
		this.asistenciaingresantes = asistenciaingresantes;
	}

	public Asistenciaingresante addAsistenciaingresante(Asistenciaingresante asistenciaingresante) {
		getAsistenciaingresantes().add(asistenciaingresante);
		asistenciaingresante.setHorariosactividad(this);

		return asistenciaingresante;
	}

	public Asistenciaingresante removeAsistenciaingresante(Asistenciaingresante asistenciaingresante) {
		getAsistenciaingresantes().remove(asistenciaingresante);
		asistenciaingresante.setHorariosactividad(null);

		return asistenciaingresante;
	}
	@JsonManagedReference
	public List<Fecha> getFechas() {
		return this.fechas;
	}

	public void setFechas(List<Fecha> fechas) {
		this.fechas = fechas;
	}

	public Fecha addFecha(Fecha fecha) {
		getFechas().add(fecha);
		fecha.setHorariosactividad(this);

		return fecha;
	}

	public Fecha removeFecha(Fecha fecha) {
		getFechas().remove(fecha);
		fecha.setHorariosactividad(null);

		return fecha;
	}
	@JsonBackReference
	public Actividad getActividad() {
		return this.actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

}