package com.unsada.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;

import com.unsada.model.Fecha;

@Qualifier("registroDeFechaService")
public interface FechaServiceApi extends CrudRepository<Fecha, Integer> {

}
