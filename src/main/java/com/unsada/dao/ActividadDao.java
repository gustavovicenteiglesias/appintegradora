package com.unsada.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.model.Actividad;
@Transactional
public interface ActividadDao extends CrudRepository<Actividad, Integer> {

}
