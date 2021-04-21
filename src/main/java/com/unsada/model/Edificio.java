package com.unsada.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the edificio database table.
 * 
 */
@Entity
@Table(name="edificio")
@NamedQuery(name="Edificio.findAll", query="SELECT e FROM Edificio e")
public class Edificio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEdificio;

	private String ciudad;

	private String direccion;

	private String nombre;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="edificioBean")
	private List<Aula> aulas;

	//bi-directional many-to-one association to Sede
	@ManyToOne(fetch=FetchType.LAZY)
	private Sede sede;

	public Edificio() {
	}

	public int getIdEdificio() {
		return this.idEdificio;
	}

	public void setIdEdificio(int idEdificio) {
		this.idEdificio = idEdificio;
	}

	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Aula addAula(Aula aula) {
		getAulas().add(aula);
		aula.setEdificioBean(this);

		return aula;
	}

	public Aula removeAula(Aula aula) {
		getAulas().remove(aula);
		aula.setEdificioBean(null);

		return aula;
	}

	public Sede getSede() {
		return this.sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

}