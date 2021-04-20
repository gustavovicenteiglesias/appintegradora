package com.unsada.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.model.Fechaingresoingresante;
@Transactional
public interface FechaingresoingresanteDao extends CrudRepository<Fechaingresoingresante, Integer> {

}
