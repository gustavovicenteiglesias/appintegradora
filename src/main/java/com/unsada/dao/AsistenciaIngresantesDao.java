package com.unsada.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.model.Asistenciaingresante;
@Transactional
public interface AsistenciaIngresantesDao extends CrudRepository<Asistenciaingresante, Integer> {
	@Query(value= "SELECT * FROM `asistenciaingresante` WHERE qr=?", nativeQuery = true)
	  Optional<Asistenciaingresante> findByQr (String qr);
}
