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
	@Column(name="id_dias")
	private int idDias;


	
	private byte domingo;

	private byte jueves;

	private byte lunes;

	private byte martes;

	private byte miercoles;

	private byte sabado;

	private byte viernes;

	@ManyToMany(mappedBy="horasactividadFecha")
	@JsonBackReference("Horario_dias")
	private List<Horariosactividad> horariosactividads;

	public HorasactividadFecha() {
	}

	public int getIdDias() {
		return idDias;
	}

	public void setIdDias(int idHoras) {
		this.idDias = idHoras;
	}

	public byte getDomingo() {
		return domingo;
	}

	public void setDomingo(byte domingo) {
		this.domingo = domingo;
	}

	public byte getJueves() {
		return jueves;
	}

	public void setJueves(byte jueves) {
		this.jueves = jueves;
	}

	public byte getLunes() {
		return lunes;
	}

	public void setLunes(byte lunes) {
		this.lunes = lunes;
	}

	public byte getMartes() {
		return martes;
	}

	public void setMartes(byte martes) {
		this.martes = martes;
	}

	public byte getMiercoles() {
		return miercoles;
	}

	public void setMiercoles(byte miercoles) {
		this.miercoles = miercoles;
	}

	public byte getSabado() {
		return sabado;
	}

	public void setSabado(byte sabado) {
		this.sabado = sabado;
	}

	public byte getViernes() {
		return viernes;
	}

	public void setViernes(byte viernes) {
		this.viernes = viernes;
	}

	@JsonBackReference
	public List<Horariosactividad> getHorariosactividads() {
		return horariosactividads;
	}

	public void setHorariosactividads(List<Horariosactividad> horariosactividads) {
		this.horariosactividads = horariosactividads;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}