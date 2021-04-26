package com.unsada.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.unsada.model.Actividad;

@Component
@Qualifier("actividadService")
public interface ActividadserviceApi extends CrudRepository<Actividad, Integer> {

}
