package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;


/**
 * The persistent class for the fechas database table.
 * 
 */
@Entity
@Table(name="fechas")
@NamedQuery(name="Fecha.findAll", query="SELECT f FROM Fecha f")
public class Fecha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFechas;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Horariosactividad
	@ManyToOne(optional = true)
	@JsonBackReference(value="fecha-horariosactividad")
	private Horariosactividad horariosactividad;

	public Fecha() {
	}

	public int getIdFechas() {
		return this.idFechas;
	}

	public void setIdFechas(int idFechas) {
		this.idFechas = idFechas;
	}
	
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Horariosactividad getHorariosactividad() {
		return this.horariosactividad;
	}

	public void setHorariosactividad(Horariosactividad horariosactividad) {
		this.horariosactividad = horariosactividad;
	}

}