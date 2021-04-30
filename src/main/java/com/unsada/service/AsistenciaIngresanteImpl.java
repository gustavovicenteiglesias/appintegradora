package com.unsada.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsada.dao.AsistenciaIngresantesDao;
import com.unsada.model.Asistenciaingresante;
@Service
public class AsistenciaIngresanteImpl implements AsistenciaIngresanteApi {
	@Autowired
	AsistenciaIngresantesDao asistenciaIngresantesDao;
	@Override
	public <S extends Asistenciaingresante> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Asistenciaingresante> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Asistenciaingresante> findById(Integer id) {
		// TODO Auto-generated method stub
		return asistenciaIngresantesDao.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return asistenciaIngresantesDao.existsById(id);
	}

	@Override
	public Iterable<Asistenciaingresante> findAll() {
		// TODO Auto-generated method stub
		return asistenciaIngresantesDao.findAll();
	}

	@Override
	public Iterable<Asistenciaingresante> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return asistenciaIngresantesDao.findAllById(ids);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Asistenciaingresante entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Asistenciaingresante> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Asistenciaingresante> findByIngresante(Integer idIngresante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Asistenciaingresante> findByIngresanteAndActividad(Integer idIngresante, Integer idActividad) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Asistenciaingresante> findByIngresanteAndActividadAndAula(Integer idIngresante, Integer idActividad,
			Integer idAula) {
		// TODO Auto-generated method stub
		return null;
	}

}
