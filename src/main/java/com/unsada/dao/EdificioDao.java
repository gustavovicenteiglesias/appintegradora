package com.unsada.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.model.Edificio;
@Transactional
public interface EdificioDao extends CrudRepository<Edificio, Integer> {

}
