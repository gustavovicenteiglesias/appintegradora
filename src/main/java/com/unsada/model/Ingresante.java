package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ingresante database table.
 * 
 */
@Entity
@Table(name="ingresante")
@NamedQuery(name="Ingresante.findAll", query="SELECT i FROM Ingresante i")
public class Ingresante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIngresante;

	private String dni;

	private byte enSeguimiento;

	private byte grupoDeRiesgo;

	private String mail;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Fechaingresoingresante
	@OneToMany(mappedBy="ingresante")
	
	private List<Fechaingresoingresante> fechaingresoingresantes;

	public Ingresante() {
	}

	public int getIdIngresante() {
		return this.idIngresante;
	}

	public void setIdIngresante(int idIngresante) {
		this.idIngresante = idIngresante;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public byte getEnSeguimiento() {
		return this.enSeguimiento;
	}

	public void setEnSeguimiento(byte enSeguimiento) {
		this.enSeguimiento = enSeguimiento;
	}

	public byte getGrupoDeRiesgo() {
		return this.grupoDeRiesgo;
	}

	public void setGrupoDeRiesgo(byte grupoDeRiesgo) {
		this.grupoDeRiesgo = grupoDeRiesgo;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Fechaingresoingresante> getFechaingresoingresantes() {
		return this.fechaingresoingresantes;
	}

	public void setFechaingresoingresantes(List<Fechaingresoingresante> fechaingresoingresantes) {
		this.fechaingresoingresantes = fechaingresoingresantes;
	}

	public Fechaingresoingresante addFechaingresoingresante(Fechaingresoingresante fechaingresoingresante) {
		getFechaingresoingresantes().add(fechaingresoingresante);
		fechaingresoingresante.setIngresante(this);

		return fechaingresoingresante;
	}

	public Fechaingresoingresante removeFechaingresoingresante(Fechaingresoingresante fechaingresoingresante) {
		getFechaingresoingresantes().remove(fechaingresoingresante);
		fechaingresoingresante.setIngresante(null);

		return fechaingresoingresante;
	}

}