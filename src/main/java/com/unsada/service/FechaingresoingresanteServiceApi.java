package com.unsada.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import com.unsada.model.Fechaingresoingresante;
import com.unsada.model.Ingresante;

@Component
@Qualifier("service")
public interface FechaingresoingresanteServiceApi extends CrudRepository<Fechaingresoingresante, Integer> {
	@Modifying
	@Transactional
	@Query(value="INSERT INTO fechaingresoingresante(fecha, ingresante_id ) VALUES (?, ?)", nativeQuery = true)
	public void  saveFechaIngresoIngresante( String date, Integer ingresante);

	public List<Fechaingresoingresante> findByIngresante(Ingresante ingresante);
}

