package com.unsada.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import javax.transaction.Transactional;

import com.unsada.model.Asistenciaingresante;

public interface AsistenciaIngresanteApi extends CrudRepository<Asistenciaingresante, Integer> {
  static final String FIND_BY_INGRESANTE ="SELECT * FROM asistenciaingresante a INNER JOIN fechaingresoingresante fi ON a.fechaingresoingresante_id = fi.id_fecha_ingresante WHERE fi.ingresante_id = :idIngresante";
  static final String FIND_BY_INGRESANTE_AND_ACTIVIDAD ="SELECT * FROM asistenciaingresante a INNER JOIN fechaingresoingresante fi ON a.fechaingresoingresante_id = fi.id_fecha_ingresante INNER JOIN  horariosactividad h on a.id_horario_actividad = h.id_horario_actividad WHERE fi.ingresante_id = :idIngresante AND h.actividad_id_actividad = :idActividad";
  static final String FIND_BY_INGRESANTE_AND_ACTIVIDAD_AND_AULA ="SELECT * FROM asistenciaingresante a INNER JOIN fechaingresoingresante fi ON a.fechaingresoingresante_id = fi.id_fecha_ingresante INNER JOIN  horariosactividad h on a.id_horario_actividad = h.id_horario_actividad INNER JOIN actividad ac on h.id_horario_actividad = a.id_actividad WHERE fi.ingresante_id = :idIngresante AND h.actividad_id_actividad = :idActividad AND act.id_aula = :idAula";

  @Query(value= FIND_BY_INGRESANTE, nativeQuery = true)
	public List<Asistenciaingresante> findByIngresante( @Param(value = "idIngresante") Integer idIngresante);

  @Query(value= FIND_BY_INGRESANTE_AND_ACTIVIDAD, nativeQuery = true)
	public List<Asistenciaingresante> findByIngresanteAndActividad( @Param(value = "idIngresante") Integer idIngresante, @Param(value = "idActividad") Integer idActividad);

  @Query(value= FIND_BY_INGRESANTE_AND_ACTIVIDAD_AND_AULA, nativeQuery = true)
  public List<Asistenciaingresante> findByIngresanteAndActividadAndAula(@Param(value = "idIngresante") Integer idIngresante, @Param(value = "idActividad") Integer idActividad, @Param(value = "idAula") Integer idAula);
}
