package com.unsada.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.unsada.model.Aula;
@Component
@Qualifier("aulaService")
public interface AulaServiceApi extends CrudRepository<Aula, Integer> {

}
