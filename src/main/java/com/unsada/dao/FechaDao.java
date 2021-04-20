package com.unsada.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.model.Fecha;
@Transactional
public interface FechaDao extends CrudRepository<Fecha, Integer> {

}
