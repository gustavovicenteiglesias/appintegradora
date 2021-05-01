package com.unsada.service;


import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

import javax.transaction.Transactional;

import com.unsada.model.Actividad;

import com.unsada.model.Horariosactividad;

@Primary
public interface HorariosactividadServiceApi extends CrudRepository<Horariosactividad, Integer> {

    public List<Horariosactividad> findByActividad(Actividad actividad);

    @Modifying
	@Transactional
	@Query(value="SELECT * FROM horariosactividad h INNER JOIN actividad a ON h.actividad_id_actividad = a.id_aula WHERE a.id_actividad = :actividad AND a.id_aula = :aula", nativeQuery = true)
	public List<Horariosactividad> findByActividadAndAula( @Param(value = "actividad") Integer actividad, @Param(value="aula") Integer aula);

}
