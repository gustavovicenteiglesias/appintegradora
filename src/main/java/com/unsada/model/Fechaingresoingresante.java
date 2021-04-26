package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Fecha_Ingresante")
	private Integer idFechaIngresante;


	@JsonProperty("fecha")
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha;

	//bi-directional many-to-one association to Asistenciaingresante
	@OneToMany(mappedBy="fechaingresoingresante")
	@JsonManagedReference(value="asistencia-fechaingresoingresante")
	private List<Asistenciaingresante> asistenciaingresante;

	//bi-directional many-to-one association to Ingresante
	@ManyToOne(optional = true)
	@JoinColumn(name = "ingresante_id")
	@JsonBackReference(value="ingresante-fecha")
	private Ingresante ingresante;

	public Fechaingresoingresante() {
		super();
	}

	public List<Asistenciaingresante> getAsistenciaingresante() {
		return asistenciaingresante;
	}

	public void setAsistenciaingresante(List<Asistenciaingresante> asistenciaingresante) {
		this.asistenciaingresante = asistenciaingresante;
	}

	public Integer getIdFechaIngresante() {
		return this.idFechaIngresante;
	}

	public void setIdFechaIngresante(Integer idFechaIngresante) {
		this.idFechaIngresante = idFechaIngresante;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
		
	public Ingresante getIngresante() {
		return this.ingresante;
	}

	public void setIngresante(Ingresante ingresante) {
		this.ingresante = ingresante;
	}

}