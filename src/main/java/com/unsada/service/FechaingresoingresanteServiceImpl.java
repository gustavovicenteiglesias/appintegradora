package com.unsada.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.unsada.dao.FechaingresoingresanteDao;
import com.unsada.model.Fechaingresoingresante;
import com.unsada.model.Ingresante;
@Service
public class FechaingresoingresanteServiceImpl implements FechaingresoingresanteServiceApi {
	@Autowired
	FechaingresoingresanteDao fechaingresoingresanteDao;
	@Override
	public <S extends Fechaingresoingresante> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Fechaingresoingresante> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Fechaingresoingresante> findById(Integer id) {
		// TODO Auto-generated method stub
		return fechaingresoingresanteDao.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return fechaingresoingresanteDao.existsById(id);
	}

	@Override
	public Iterable<Fechaingresoingresante> findAll() {
		// TODO Auto-generated method stub
		return fechaingresoingresanteDao.findAll();
	}

	@Override
	public Iterable<Fechaingresoingresante> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return fechaingresoingresanteDao.findAllById(ids);
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
	public void delete(Fechaingresoingresante entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Fechaingresoingresante> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveFechaIngresoIngresante(String date, Integer ingresante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fechaingresoingresante> findByIngresante(Ingresante ingresante) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
