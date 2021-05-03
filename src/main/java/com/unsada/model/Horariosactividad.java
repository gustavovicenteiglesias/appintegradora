package com.unsada.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
	@Column(name="id_horario_actividad")
	private int idHorarioActividad;

	
	
	@Column(name="hora_inicio")
	private Time horaInicio;

	@Column(name="hora_fin")
	private Time horasFin;

	//bi-directional many-to-one association to Asistenciaingresante
	@OneToMany(mappedBy="horariosactividad")
	@JsonManagedReference(value="asistencia-horariosactividad")
	private List<Asistenciaingresante> asistenciaingresantes;

	//bi-directional many-to-one association to Fecha
	@OneToMany(mappedBy="horariosactividad")
	@JsonManagedReference(value="fecha-horariosactividad")
	private List<Fecha> fechas;

	//bi-directional many-to-one association to Actividad
	@ManyToOne(optional = true)
	@JsonBackReference(value="asistencia-horariosactividad")
	private Actividad actividad;

	//bi-directional many-to-one association to HorasactividadFecha
	/*@ManyToOne(optional = true)
	@JoinColumn(name="horasactividad_fechas_id_horas")
	private HorasactividadFecha horasactividadFecha;*/
	@JoinTable(
	        name = "rel_horariosactividad_horariosfecha",
	        joinColumns = @JoinColumn(name = "FK_HORARIOSACTIVIDAD", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_HORARIOSFECHA", nullable = false)
	    )
	@ManyToMany(cascade = CascadeType.ALL)
	
	private List <HorasactividadFecha> horasactividadFecha;
	
	
	public Horariosactividad() {
	}


	public int getIdHorarioActividad() {
		return idHorarioActividad;
	}


	public void setIdHorarioActividad(int idHorarioActividad) {
		this.idHorarioActividad = idHorarioActividad;
	}


	public Time getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}


	public Time getHorasFin() {
		return horasFin;
	}


	public void setHorasFin(Time horasFin) {
		this.horasFin = horasFin;
	}

	@JsonManagedReference
	public List<Asistenciaingresante> getAsistenciaingresantes() {
		return asistenciaingresantes;
	}


	public void setAsistenciaingresantes(List<Asistenciaingresante> asistenciaingresantes) {
		this.asistenciaingresantes = asistenciaingresantes;
	}


	public List<Fecha> getFechas() {
		return fechas;
	}


	public void setFechas(List<Fecha> fechas) {
		this.fechas = fechas;
	}


	public Actividad getActividad() {
		return actividad;
	}


	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}


	public List<HorasactividadFecha> getHorasactividadFecha() {
		return horasactividadFecha;
	}


	public void setHorasactividadFecha(List<HorasactividadFecha> horasactividadFecha) {
		this.horasactividadFecha = horasactividadFecha;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}