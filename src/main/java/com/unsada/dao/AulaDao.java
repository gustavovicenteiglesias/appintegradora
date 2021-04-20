package com.unsada.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.model.Aula;
@Transactional
public interface AulaDao extends CrudRepository<Aula, Integer> {

}
