package com.unsada.service;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import com.unsada.model.Ingresante;

public interface IngresanteServiceApi extends CrudRepository<Ingresante, Integer> {
	@Modifying
	@Transactional
	@Query(value="INSERT INTO ingresante( dni, en_seguimiento, grupo_de_riesgo, mail, nombre, telefono ) VALUES (?,?,?,?,?,?)",nativeQuery = true )
	public void  saveingresante(String dni,byte enseguimiento,byte riesgo,String mail,String nombre,String telefono);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE ingresante SET id_ingresante=?,dni=?,en_seguimiento=?,grupo_de_riesgo=?,mail=?,nombre=?,telefono=? WHERE id_ingresante=?",nativeQuery = true )
	public void update (Integer id,String dni,byte enseguimiento,byte gruporiego,String mail, String nombre,String telefono,Integer where);

	public Ingresante findByDni(String dni);

	public Ingresante findByIdIngresante(int idIngresante);
}
