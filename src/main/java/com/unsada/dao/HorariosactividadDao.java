package com.unsada.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.model.Horariosactividad;

@Transactional
public interface HorariosactividadDao extends CrudRepository<Horariosactividad, Integer> {

}
