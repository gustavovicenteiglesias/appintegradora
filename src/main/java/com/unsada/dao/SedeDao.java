package com.unsada.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.model.Sede;
@Transactional
public interface SedeDao extends CrudRepository<Sede, Integer> {

}
