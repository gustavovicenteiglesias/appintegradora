package com.unsada.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.model.Asistenciaingresante;
@Transactional
public interface AsistenciaIngresantesDao extends CrudRepository<Asistenciaingresante, Integer> {

}
