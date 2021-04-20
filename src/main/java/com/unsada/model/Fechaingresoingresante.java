package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fechaingresoingresante database table.
 * 
 */
@Entity
@Table(name="fechaingresoingresante")
@NamedQuery(name="Fechaingresoingresante.findAll", query="SELECT f FROM Fechaingresoingresante f")
public class Fechaingresoingresante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idFechaIngresante;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Asistenciaingresante
	@OneToMany(mappedBy="fechaingresoingresante")
	private List<Asistenciaingresante> asistenciaingresantes;

	//bi-directional many-to-one association to Ingresante
	@ManyToOne
	@JoinColumn(name="idIngresante")
	private Ingresante ingresante;

	public Fechaingresoingresante() {
	}

	public String getIdFechaIngresante() {
		return this.idFechaIngresante;
	}

	public void setIdFechaIngresante(String idFechaIngresante) {
		this.idFechaIngresante = idFechaIngresante;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Asistenciaingresante> getAsistenciaingresantes() {
		return this.asistenciaingresantes;
	}

	public void setAsistenciaingresantes(List<Asistenciaingresante> asistenciaingresantes) {
		this.asistenciaingresantes = asistenciaingresantes;
	}

	public Asistenciaingresante addAsistenciaingresante(Asistenciaingresante asistenciaingresante) {
		getAsistenciaingresantes().add(asistenciaingresante);
		asistenciaingresante.setFechaingresoingresante(this);

		return asistenciaingresante;
	}

	public Asistenciaingresante removeAsistenciaingresante(Asistenciaingresante asistenciaingresante) {
		getAsistenciaingresantes().remove(asistenciaingresante);
		asistenciaingresante.setFechaingresoingresante(null);

		return asistenciaingresante;
	}

	public Ingresante getIngresante() {
		return this.ingresante;
	}

	public void setIngresante(Ingresante ingresante) {
		this.ingresante = ingresante;
	}

}