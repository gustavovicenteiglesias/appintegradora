package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sede database table.
 * 
 */
@Entity
@Table(name="sede")
@NamedQuery(name="Sede.findAll", query="SELECT s FROM Sede s")
public class Sede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSede;

	private String lugar;

	private String nombre;

	//bi-directional many-to-one association to Edificio
	@OneToMany(mappedBy="sede")
	private List<Edificio> edificios;

	public Sede() {
	}

	public int getIdSede() {
		return this.idSede;
	}

	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Edificio> getEdificios() {
		return this.edificios;
	}

	public void setEdificios(List<Edificio> edificios) {
		this.edificios = edificios;
	}

	public Edificio addEdificio(Edificio edificio) {
		getEdificios().add(edificio);
		edificio.setSede(this);

		return edificio;
	}

	public Edificio removeEdificio(Edificio edificio) {
		getEdificios().remove(edificio);
		edificio.setSede(null);

		return edificio;
	}

}