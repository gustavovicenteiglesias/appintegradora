package com.unsada.dao;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unsada.model.Ingresante;
@Transactional
public interface IngresanteDao extends CrudRepository<Ingresante, Integer> {

}
